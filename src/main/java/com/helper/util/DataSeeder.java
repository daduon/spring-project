package com.helper.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.helper.model.User;
import com.helper.repository.UserRepository;

import jakarta.annotation.PostConstruct;

@Component
public class DataSeeder {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;

    @PostConstruct
    public void init() {
        if (userRepository.count() == 0) {
            User admin = new User();
            admin.setUsername("admin");
            admin.setPassword(encoder.encode("admin123"));
            admin.setRoles(List.of("ADMIN"));

            User user = new User();
            user.setUsername("user");
            user.setPassword(encoder.encode("user123"));
            user.setRoles(List.of("USER"));

            userRepository.saveAll(List.of(admin, user));
        }
    }
}
