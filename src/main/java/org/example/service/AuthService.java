package org.example.service;

import org.example.dao.UserRepository;

public class AuthService {
    private final UserRepository repository = new UserRepository();

    public boolean authenticate(String user, String password) {
        return repository.find(user).equals(password);
    }
}