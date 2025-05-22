package org.example.ui;

import org.example.service.UserService;

public class MainController {
    private final UserService userService = new UserService();

    public void run() {
        userService.registerUser("Alice");
    }
}