package com.helper.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helper.model.User;
import com.helper.repository.UserRepository;


@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> updateUser(Long id, User getUser) {
        return userRepository.findById(id).map(user -> {
            user.setUsername(getUser.getUsername());
            user.setPassword(getUser.getPassword());
            return userRepository.save(user);
        });
    }
    
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
