package com.philosophyprogrammers.service.users;

import com.philosophyprogrammers.entity.User;
import com.philosophyprogrammers.repository.UserRepository;
import com.philosophyprogrammers.service.users.UserService;
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
   /**
    *     CREATE
    *
   * */
    @Override
    public User createdNewUser(User account) {
        return userRepository.save(account);
    }

//    @Override
//    public User editUser(User user) {
//        return userRepository.save(user);
//    }

    /**
     *     GET ALL
     *
     * */
    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    /**
     *     FIND BY ID
     *
     * */
    @Override
    public Optional<User> findById(long id) {
        return userRepository.findById(id);
    }

    /**
     *     DELETED User
     *
     * */
    @Override
    public void deleteUser(User user) {
        userRepository.deleteById(user.getId());
    }
// ================================================

}
