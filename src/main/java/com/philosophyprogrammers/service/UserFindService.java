package com.philosophyprogrammers.service;

import com.philosophyprogrammers.entity.PhilosophyProgrammersEntity;
import com.philosophyprogrammers.modules.UserName;

import java.util.Optional;

public interface UserFindService {

    Optional<PhilosophyProgrammersEntity> findById(Long id);

    Optional<PhilosophyProgrammersEntity> findByUsername(UserName userName);
}
