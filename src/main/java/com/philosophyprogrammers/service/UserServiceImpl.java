package com.philosophyprogrammers.service;

import com.philosophyprogrammers.entity.User;
import com.philosophyprogrammers.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // функция проверки Email на пустоту
    // ================================================
//    private boolean emailExists(Email email) {
//        return userRepository.findUserByEmail(email) != null;
//    }

    // ================================================

    @Override
    public User createdNewUser(User account) {
        return userRepository.save(account);
    }

    @Override
    public User editUser(User user) {
        return userRepository.save(user);
    }
//
//    @Override
//    public void deleteUser(long id) {
//        userRepository.delete(id);
//    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(long id) {
        return userRepository.findById(id);
    }

    // ================================================

}
