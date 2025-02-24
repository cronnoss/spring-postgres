package com.cronnoss.springpostgres.service;

import com.cronnoss.springpostgres.dto.User;
import com.cronnoss.springpostgres.exception.UserNotFoundException;
import com.cronnoss.springpostgres.repository.UserDao;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public void createUser(String username) {
        userDao.createUser(username);
    }

    public Optional<User> getUser(Long id) {
        return Optional.ofNullable(userDao.getUser(id).orElseThrow(() ->
                new UserNotFoundException("User not found with id: " + id)));
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }
}
