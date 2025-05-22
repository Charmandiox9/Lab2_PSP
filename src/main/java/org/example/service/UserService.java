package org.example.service;

import org.example.dao.UserRepository;

import org.example.ui.UserView; // ❌ No permitido
import org.example.service.AuthService; // ⚠️ Dependencia cruzada

public class UserService {
    /*public void displayUser() {
        UserView view = new UserView(); // ❌ Service usando UI
        view.showUser("Bob");
    }*/

    /*private final AuthService auth = new AuthService(); // ⚠️ Puede considerarse mal diseño si son mutuamente dependientes

    public void doAuth(String user, String pass) {
        auth.authenticate(user, pass);
    }*/

    private final UserRepository repository = new UserRepository();

    public void registerUser(String name) {
        repository.save(name);
    }

    public void getUserInfo(String name) {
        System.out.println("User info for: " + name);
    }
}