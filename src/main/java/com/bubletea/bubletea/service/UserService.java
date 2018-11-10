package com.bubletea.bubletea.service;

import com.bubletea.bubletea.entity.User;

public interface UserService {
    User getUserByUsername(String username);

    User getUserById(int id);
}
