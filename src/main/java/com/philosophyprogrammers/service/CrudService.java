package com.philosophyprogrammers.service;

import com.philosophyprogrammers.entity.User;

public interface CrudService {
    User registerNewUser(User account);

    void saveRegisteredUser(User user);
}
