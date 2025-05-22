package org.example.ui;

import org.example.service.UserService;

public class UserView {
    private final UserService service = new UserService();

    public void showUser(String name) {
        service.getUserInfo(name);
    }
}