package com.bubletea.bubletea.service;

import com.bubletea.bubletea.entity.Role;
import com.bubletea.bubletea.entity.User;
import com.bubletea.bubletea.model.dto.UserDto;
import com.bubletea.bubletea.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User getUserById(int id) {
        User user = userRepository.findById(id);
        return user;
    }
}
