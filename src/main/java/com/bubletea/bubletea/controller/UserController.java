package com.bubletea.bubletea.controller;


import com.bubletea.bubletea.exception.RegisterUserException;
import com.bubletea.bubletea.model.dto.UserDto;
import com.bubletea.bubletea.service.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping("/users")
@RestController
public class UserController {

    @Autowired
    CustomUserDetailService customUserDetailService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@Valid @RequestBody UserDto userDto) {
        try{
            customUserDetailService.registerUser(userDto);
        } catch (RegisterUserException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
        }

        return new ResponseEntity<>("OK", HttpStatus.CREATED);
    }
}
