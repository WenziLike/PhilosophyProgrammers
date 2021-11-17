package com.philosophyprogrammers.service.users;

import com.philosophyprogrammers.dto.UserDTO;
import com.philosophyprogrammers.entity.GroupEntity;
import com.philosophyprogrammers.entity.TokenEntity;
import com.philosophyprogrammers.entity.UserEntity;
import com.philosophyprogrammers.exceptions.InvalidTokenException;
import com.philosophyprogrammers.exceptions.UnknownIdentifierException;
import com.philosophyprogrammers.exceptions.UserAlreadyExistException;
import com.philosophyprogrammers.repository.GroupRepository;
import com.philosophyprogrammers.repository.UserRepository;
import com.philosophyprogrammers.security.token.repository.TokenRepository;
import com.philosophyprogrammers.security.token.service.TokenService;
import com.philosophyprogrammers.service.email.EmailService;
import com.philosophyprogrammers.service.email.context.AccountVerificationEmailContext;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.Objects;

/**
 * Implementation of {@link UserService} interface
 *
 * @author Viacheslav Murakhin
 * @version 1.0
 */

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final EmailService emailService;
    private final TokenService tokenService;
    private final TokenRepository tokenRepository;
    private final GroupRepository groupRepository;

    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder,
                           EmailService emailService,
                           TokenService tokenService,
                           TokenRepository tokenRepository,
                           GroupRepository groupRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.emailService = emailService;
        this.tokenService = tokenService;
        this.tokenRepository = tokenRepository;
        this.groupRepository = groupRepository;
    }

    @Value("${site.base.url.https}")
    private String baseURL;

    @Override
    public void register(UserDTO user) throws UserAlreadyExistException {

        if (checkUserExist(user.getEmail())) {
            throw new UserAlreadyExistException("User already exists for this email");
        }

        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);
        encodePassword(user, userEntity);
        updateCustomerGroup(userEntity);
        userRepository.save(userEntity);
        sendRegistrationConfirmationEmail(userEntity);
    }

    private void updateCustomerGroup(UserEntity userEntity) {
        GroupEntity group = groupRepository.findByCode("user");
        userEntity.addUserGroups(group);
    }

    @Override
    public boolean checkUserExist(String email) {
        return userRepository.findByEmail(email) != null ? true : false;
    }

    @Override
    public void sendRegistrationConfirmationEmail(UserEntity user) {
        TokenEntity tokenEntity = tokenService.createToken();
        tokenEntity.setUser(user);
        tokenRepository.save(tokenEntity);
        AccountVerificationEmailContext emailContext = new AccountVerificationEmailContext();
        emailContext.init(user);
        emailContext.setToken(tokenEntity.getToken());
        emailContext.buildVerificationUrl(baseURL, tokenEntity.getToken());
        try {
            emailService.sendMail(emailContext);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean verifyUser(String token) throws InvalidTokenException {

        TokenEntity tokenEntity = tokenService.findByToken(token);

        if (Objects.isNull(tokenEntity) ||
                !StringUtils.equals(token, tokenEntity.getToken()) || tokenEntity.isExpired()) {
            throw new InvalidTokenException("Token is not valid");
        }

        UserEntity user = userRepository.getById(tokenEntity.getUser().getId());

        if (Objects.isNull(user)) {
            return false;
        }
        user.setAccountVerified(true);
        userRepository.save(user);// let's same user details
        tokenService.removeToken(tokenEntity);// we don't need invalid password now
        return true;
    }

    @Override
    public UserEntity getUserById(String id) throws UnknownIdentifierException {
        UserEntity user = userRepository.findByEmail(id);

        if (user == null ||
                BooleanUtils.isFalse(user.isAccountVerified())) {
            // we will ignore in case account is not verified or account does not exists
            throw new UnknownIdentifierException("unable to find account or account is not active");
        }
        return user;
    }

    private void encodePassword(UserDTO source, UserEntity target) {
        target.setPassword(passwordEncoder.encode(source.getPassword()));
    }
}
