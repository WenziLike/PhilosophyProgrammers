package com.philosophyprogrammers.repository;

import com.philosophyprogrammers.entity.User;
import com.philosophyprogrammers.modules.user.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByEmail(Email email);
    User save(User user);
}

