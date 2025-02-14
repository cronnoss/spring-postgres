package com.cronnoss.springpostgres;

import com.cronnoss.springpostgres.config.DataSourceConfig;
import com.cronnoss.springpostgres.repository.UserDao;
import com.cronnoss.springpostgres.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                DataSourceConfig.class,
                UserDao.class,
                UserService.class);
        UserService userService = context.getBean(UserService.class);

        // Testing CRUD operations
        userService.createUser("john_doe");
        userService.getAllUsers().forEach(user -> System.out.println("User: " + user.getUsername()));
        userService.getUser(1L).ifPresent(user -> System.out.println("Found: " + user.getUsername()));
        userService.deleteUser(1L);
    }

}
