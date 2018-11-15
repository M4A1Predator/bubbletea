package com.bubletea.bubletea.service;

import com.bubletea.bubletea.constant.UserRole;
import com.bubletea.bubletea.entity.Role;
import com.bubletea.bubletea.entity.User;
import com.bubletea.bubletea.exception.RegisterUserException;
import com.bubletea.bubletea.model.dto.UserDto;
import com.bubletea.bubletea.repository.UserRepository;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(s);
        if (user == null) {
            throw new UsernameNotFoundException("No user");
        }
        return user;
    }

    @Transactional
    public User registerUser(UserDto userDto) throws RegisterUserException {
        User user = new User();

        // Check duplicate name
        if (usernameExist(userDto.getUsername())) {
            throw new RegisterUserException("username is already used");
        }

        // Set username and password
        user.setUsername(userDto.getUsername());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

        // Assign role
        List<Role> roles = new ArrayList<>();
        Role userRole = new Role(UserRole.USER.getId());
        roles.add(userRole);
        user.setRoles(roles);

        // Save
        User savedUser = userRepository.save(user);

        return savedUser;
    }

    private boolean usernameExist(String username) {
        User user = userRepository.findByUsername(username);
        return user != null;
    }
}
