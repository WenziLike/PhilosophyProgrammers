package com.philosophyprogrammers.service.account;

import com.philosophyprogrammers.email.EmailService;
import com.philosophyprogrammers.entity.TokenEntity;
import com.philosophyprogrammers.entity.UserEntity;
import com.philosophyprogrammers.exceptions.InvalidTokenException;
import com.philosophyprogrammers.exceptions.UnknownIdentifierException;
import com.philosophyprogrammers.repository.UserRepository;
import com.philosophyprogrammers.security.token.repository.TokenRepository;
import com.philosophyprogrammers.security.token.service.TokenService;
import com.philosophyprogrammers.service.account.context.ForgotPasswordEmailContext;
import com.philosophyprogrammers.service.users.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.Objects;


@Service("accountService")
public class AccountServiceImpl implements AccountService {

    private final UserService userService;
    private final TokenService tokenService;
    private final TokenRepository tokenRepository;
    private final EmailService emailService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Value("${site.base.url.https}")
    private String baseURL;

    public AccountServiceImpl(UserService userService,
                              TokenService tokenService,
                              TokenRepository tokenRepository,
                              EmailService emailService,
                              UserRepository userRepository,
                              PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.tokenService = tokenService;
        this.tokenRepository = tokenRepository;
        this.emailService = emailService;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void forgottenPassword(String userName) throws UnknownIdentifierException {
        UserEntity user = userService.getUserById(userName);
        sendResetPasswordEmail(user);
    }

    @Override
    public void updatePassword(String password, String token) throws InvalidTokenException, UnknownIdentifierException {
        TokenEntity tokenEntity = tokenService.findByToken(token);
        if (Objects.isNull(tokenEntity) || !StringUtils.equals(token, tokenEntity.getToken()) || tokenEntity.isExpired()) {
            throw new InvalidTokenException("Token is not valid");
        }
        UserEntity user = userRepository.getOne(tokenEntity.getUser().getId());
        if (Objects.isNull(user)) {
            throw new UnknownIdentifierException("unable to find user for the token");
        }
        tokenService.removeToken(tokenEntity);
        user.setPassword(passwordEncoder.encode(password));
        userRepository.save(user);
    }


    protected void sendResetPasswordEmail(UserEntity user) {
        TokenEntity tokenEntity = tokenService.createToken();
        tokenEntity.setUser(user);
        tokenRepository.save(tokenEntity);
        ForgotPasswordEmailContext emailContext = new ForgotPasswordEmailContext();
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
    public boolean loginDisabled(String username) {
        UserEntity user = userRepository.findByEmail(username);
        return user != null ? user.isLoginDisabled() : false;
    }
}
