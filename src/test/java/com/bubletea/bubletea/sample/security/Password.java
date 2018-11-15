package com.bubletea.bubletea.sample.security;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import static org.junit.Assert.*;

@SpringBootTest
public class Password {

    @Test
    public void testPassword() {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        String password = "password";
        String a = encoder.encode(password);
        System.out.println(a);

        assertTrue(encoder.matches(password, a));

        String secret = "secret";
        String b = encoder.encode(secret);
        System.out.println(b);
        assertTrue(encoder.matches(secret, b));
    }
}
