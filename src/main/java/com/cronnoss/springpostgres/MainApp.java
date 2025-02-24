package com.cronnoss.springpostgres;

import com.cronnoss.springpostgres.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan(basePackages = "com.cronnoss.springpostgres")
public class MainApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainApp.class);
        UserService userService = context.getBean(UserService.class);

        // Testing CRUD operations
        userService.createUser("john_doe");
        userService.getAllUsers().forEach(user -> System.out.println("User: " + user.getUsername()));
        userService.getUser(1L).ifPresent(user -> System.out.println("Found: " + user.getUsername()));
        userService.deleteUser(1L);
    }

}
