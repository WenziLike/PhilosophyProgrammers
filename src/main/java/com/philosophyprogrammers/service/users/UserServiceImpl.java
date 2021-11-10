package com.philosophyprogrammers.service.users;

import com.philosophyprogrammers.dto.UserDTO;
import com.philosophyprogrammers.entity.TokenEntity;
import com.philosophyprogrammers.entity.UserEntity;
import com.philosophyprogrammers.exceptions.InvalidTokenException;
import com.philosophyprogrammers.exceptions.UnknownIdentifierException;
import com.philosophyprogrammers.exceptions.UserAlreadyExistException;
import com.philosophyprogrammers.repository.UserRepository;
import com.philosophyprogrammers.security.token.repository.TokenRepository;
import com.philosophyprogrammers.security.token.service.TokenService;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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
    private final TokenService tokenService;
    private final TokenRepository tokenRepository;

    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder,
                           TokenService tokenService, TokenRepository tokenRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.tokenService = tokenService;
        this.tokenRepository = tokenRepository;
    }

    @Override
    public void register(UserDTO userDTO) throws UserAlreadyExistException {

        if (checkUserExist(userDTO.getEmail())) {
            throw new UserAlreadyExistException("User already exists for this email");
        }

        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userDTO, userEntity);
        encodePassword(userDTO, userEntity);
        userRepository.save(userEntity);
        sendRegistrationConfirmationEmail(userEntity);
    }

    @Override
    public boolean checkUserExist(String email) {
        return userRepository.findByEmail(email) != null ? true : false;
    }

    @Override
    public void sendRegistrationConfirmationEmail(UserEntity userEntity) {
        TokenEntity tokenEntity = tokenService.createToken();
        tokenEntity.setUserEntity(userEntity);
        tokenRepository.save(tokenEntity);
    }

    @Override
    public boolean verifyTokenUser(String token) throws InvalidTokenException {

        TokenEntity tokenEntity = tokenService.findByToken(token);

        if (Objects.isNull(tokenEntity) ||
                !StringUtils.equals(token, tokenEntity.getToken()) || tokenEntity.isExpired()) {
            throw new InvalidTokenException("Token is not valid");
        }

        UserEntity userEntity = userRepository.getById(tokenEntity.getUserEntity().getId());

        if (Objects.isNull(userEntity)) {
            return false;
        }
        userEntity.setAccountVerified(true);
        userRepository.save(userEntity);// let's same user details
        tokenService.removeToken(tokenEntity);// we don't need invalid password now
        return true;
    }

    @Override
    public UserEntity getUserById(String id) throws UnknownIdentifierException {
        UserEntity userEntity = userRepository.findByEmail(id);

        if (userEntity == null ||
                BooleanUtils.isFalse(userEntity.isAccountVerified())) {
            // we will ignore in case account is not verified or account does not exists
            throw new UnknownIdentifierException("unable to find account or account is not active");
        }
        return userEntity;
    }

    private void encodePassword(UserDTO userDTO, UserEntity userEntity) {
        userEntity.setPassword(passwordEncoder.encode(userDTO.getPassword()));
    }
}
