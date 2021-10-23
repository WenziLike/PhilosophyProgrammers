package com.philosophyprogrammers.repository;

import com.philosophyprogrammers.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
//    void delete(long id);
}

