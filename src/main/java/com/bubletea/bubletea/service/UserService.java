package com.bubletea.bubletea.service;

import com.bubletea.bubletea.entity.User;
import com.bubletea.bubletea.entity.UserData;

public interface UserService {
    User getUserByUsername(String username);

    User getUserById(int id);
}
