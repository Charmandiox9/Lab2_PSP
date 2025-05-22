package org.example.ui;

import org.example.dao.ConnectionManager;
import org.example.service.AuthService;

public class LoginController {
    //private final ConnectionManager cm = new ConnectionManager(); // <- violación!

    private final AuthService authService = new AuthService();

    public boolean login(String username, String password) {
        return authService.authenticate(username, password);
    }
}