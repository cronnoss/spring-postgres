package com.cronnoss.springpostgres.service;

import com.cronnoss.springpostgres.entities.User;
import com.cronnoss.springpostgres.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService implements CommandLineRunner {

    private final UserRepository userRepository;

    @Override
    public void run(String... args) {

        createUser("john_doe");

        getUser(2L);

        getAllUsers().forEach(user -> log.info("User: " + user.getUsername()));

        deleteUser(2L);
    }

    public User createUser(String username) {
        User user = new User();
        user.setUsername(username);
        return userRepository.createUser(user);
    }

    public User getUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
