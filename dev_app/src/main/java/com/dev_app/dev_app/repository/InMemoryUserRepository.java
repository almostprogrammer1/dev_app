package com.dev_app.dev_app.repository;

import java.util.HashMap;
import java.util.Map;

import com.dev_app.dev_app.model.User;

public class InMemoryUserRepository {
    private Map<String, User> users;

    public InMemoryUserRepository() {
        this.users = new HashMap<>();
    }

    public void save(User user) {
        users.put(user.getUsername(), user);
    }

    public User findByUsername(String username) {
        return users.get(username);
    }

    public boolean existsByUsername(String username) {
        return users.containsKey(username);
    }
}