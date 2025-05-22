package org.example.dao;

import org.example.service.AuthService; // ❌ DAO no debe conocer Service

public class UserRepository {

    /*public void doSomethingWeird() {
        AuthService auth = new AuthService(); // ❌ Mal diseño
        auth.authenticate("admin", "1234");
    }*/

    public void save(String name) {
        System.out.println("User " + name + " saved.");
    }

    public String find(String user) {
        return "secret";
    }
}