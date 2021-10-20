package com.philosophyprogrammers.service;

import com.philosophyprogrammers.entity.PhilosophyProgrammersEntity;
import com.philosophyprogrammers.modules.UserName;
import com.philosophyprogrammers.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserFindService{

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<PhilosophyProgrammersEntity> getUsers() {
        return userRepository.findAll();
    }


    public void signUpUser(PhilosophyProgrammersEntity philosophyProgrammersEntity) {
        if (philosophyProgrammersEntity.getId() != null) {
            IllegalArgumentException exception =
                    new IllegalArgumentException("New book not make id");
            throw exception;
        }
        userRepository.save(philosophyProgrammersEntity);
    }


    @Override
    public Optional<PhilosophyProgrammersEntity> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<PhilosophyProgrammersEntity> findByUsername(UserName userName) {
        return userRepository.findFirstByProfileUserName(userName);
    }
}
