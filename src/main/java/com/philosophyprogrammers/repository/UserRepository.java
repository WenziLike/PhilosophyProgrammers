package com.philosophyprogrammers.repository;

import com.philosophyprogrammers.entity.PhilosophyProgrammersEntity;
import com.philosophyprogrammers.modules.Email;
import com.philosophyprogrammers.modules.UserName;
import com.philosophyprogrammers.modules.UserSignUp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<PhilosophyProgrammersEntity, Long> {
    UserName save(UserName user);

    Optional<PhilosophyProgrammersEntity> findById(Long id);

    Optional<PhilosophyProgrammersEntity> findFirstByEmail(Email email);

    Optional<PhilosophyProgrammersEntity> findFirstByProfileUserName(UserName userName);

}

