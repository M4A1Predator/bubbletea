package com.bubletea.bubletea.Controller;

import com.bubletea.bubletea.entity.User;
import com.bubletea.bubletea.service.CustomUserDetailService;
import com.bubletea.bubletea.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/test")
@RestController
public class TestController {

    @Autowired
    UserService userService;

    @GetMapping("/hello")
    public String test() {
        return "hello";
    }

    @GetMapping("/user")
    public String getUser() {
        User user = userService.getUserByUsername("admin");
        return user.getUsername();
    }
}
