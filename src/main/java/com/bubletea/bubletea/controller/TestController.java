package com.bubletea.bubletea.controller;

import com.bubletea.bubletea.entity.User;
import com.bubletea.bubletea.model.CustomPrincipal;
import com.bubletea.bubletea.repository.UserRepository;
import com.bubletea.bubletea.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RequestMapping("/test")
@RestController
public class TestController {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/hello")
    public String test() {
        return "hello";
    }

    @GetMapping("/user")
//    @PreAuthorize("hasAuthority('user')")
    public User getUser(CustomPrincipal principal) {
        return userRepository.findById(principal.getId());
    }
}
