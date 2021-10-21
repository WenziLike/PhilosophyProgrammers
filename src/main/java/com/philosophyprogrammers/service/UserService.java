package com.philosophyprogrammers.service;

import com.philosophyprogrammers.entity.User;
import com.philosophyprogrammers.modules.user.Email;
import com.philosophyprogrammers.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements CrudService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    @Override
    public User registerNewUser(User account) {
        if (emailExists(account.getEmail())) {
            throw
                    new IllegalArgumentException
                            ("There is an account with that email address: "
                                    + account.getEmail());
        }

        User user = new User();

        user.setFirstName(account.getFirstName());
        user.setLastName(account.getFirstName());
        user.setEmail(account.getEmail());
        user.setPassword(account.getPassword());
//        user.setRoles(Arrays.asList(roleRepository.findByName("ROLE_USER")));
        return userRepository.save(user);
    }

    @Override
    public void saveRegisteredUser(User user) {
        userRepository.save(user);
    }

    // функция проверки Email на пустоту
    private boolean emailExists(Email email) {
        return userRepository.findUserByEmail(email) != null;
    }

}
