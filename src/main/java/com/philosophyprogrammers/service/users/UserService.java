package com.philosophyprogrammers.service.users;

import com.philosophyprogrammers.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    User createdNewUser(User account);

    List<User> getAll();

    Optional<User> findById(long id);

    void deleteUser(User user);
}
