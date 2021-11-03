package com.philosophyprogrammers.service.users;

import com.philosophyprogrammers.dto.UserDTO;
import com.philosophyprogrammers.entity.UserEntity;
import com.philosophyprogrammers.exceptions.UserAlreadyExistException;
import org.springframework.stereotype.Service;

/**
 * Service class for {@link UserEntity}
 *
 * @author Viacheslav Murakhin
 * @version 1.0
 */

@Service
public interface UserService {

    void register(UserDTO userDTO) throws UserAlreadyExistException;

    boolean checkUserExist(String email);

}
