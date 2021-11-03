package com.philosophyprogrammers.service.users;

import com.philosophyprogrammers.dto.UserDTO;
import com.philosophyprogrammers.entity.UserEntity;
import com.philosophyprogrammers.exceptions.UserAlreadyExistException;
import com.philosophyprogrammers.repository.UserRepository;
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

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void register(UserDTO userDTO) throws UserAlreadyExistException {

        if(checkUserExist(userDTO.getEmail())){
            throw new UserAlreadyExistException("User already exists for this email");
        }

        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userDTO, userEntity);
        encodePassword(userEntity, userDTO);
        userRepository.save(userEntity);
    }

    @Override
    public boolean checkUserExist(String email) {
        return userRepository.findByEmail(email) != null;
    }

    private void encodePassword(UserEntity userEntity,UserDTO userDTO) {
        userEntity.setPassword(passwordEncoder.encode(userDTO.getPassword()));
    }
}
