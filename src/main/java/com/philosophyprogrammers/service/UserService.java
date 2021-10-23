package com.philosophyprogrammers.service;

import com.philosophyprogrammers.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {
    User createdNewUser(User account);
    User editUser(User user);
//    void deleteUser(long id);
    List<User> getAll();
}
