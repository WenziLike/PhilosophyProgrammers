package com.philosophyprogrammers.service;

import com.philosophyprogrammers.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    User createdNewUser(User account);
    User editUser(User user);
//    void deleteUser(long id);
    List<User> getAll();

    Optional<User> findById(long id);
}
