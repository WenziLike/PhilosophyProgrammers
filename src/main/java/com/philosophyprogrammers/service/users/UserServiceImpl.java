package com.philosophyprogrammers.service.users;

import com.philosophyprogrammers.dto.UserDTO;
import com.philosophyprogrammers.entity.TokenEntity;
import com.philosophyprogrammers.entity.UserEntity;
import com.philosophyprogrammers.exceptions.UserAlreadyExistException;
import com.philosophyprogrammers.repository.UserRepository;
import com.philosophyprogrammers.security.token.repository.TokenRepository;
import com.philosophyprogrammers.security.token.service.TokenService;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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
        encodePassword(userEntity, userDTO);
        userRepository.save(userEntity);
        sendRegistrationConfirmationEmail(userEntity);
    }

    @Override
    public boolean checkUserExist(String email) {
        return userRepository.findByEmail(email) != null;
    }

    @Override
    public void sendRegistrationConfirmationEmail(UserEntity user) {
        TokenEntity tokenEntity = tokenService.createToken();
        tokenEntity.setUserEntity(user);
        tokenRepository.save(tokenEntity);
    }

    private void encodePassword(UserEntity userEntity, UserDTO userDTO) {
        userEntity.setPassword(passwordEncoder.encode(userDTO.getPassword()));
    }
}
