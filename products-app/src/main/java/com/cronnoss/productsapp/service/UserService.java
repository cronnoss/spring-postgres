package com.cronnoss.productsapp.service;

import com.cronnoss.productsapp.entities.User;
import com.cronnoss.productsapp.exception.UserNotFoundException;
import com.cronnoss.productsapp.repository.UserRepository;
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
        return userRepository.save(user);
    }

    public User getUser(Long id) {
        return userRepository.findById(id).orElseThrow(() ->
                new UserNotFoundException("User not found with id: " + id));
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
