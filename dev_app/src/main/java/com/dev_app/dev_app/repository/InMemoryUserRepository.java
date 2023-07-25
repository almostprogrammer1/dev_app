package com.dev_app.dev_app.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.dev_app.dev_app.model.User;

import lombok.NoArgsConstructor;

@Repository
@NoArgsConstructor
public class InMemoryUserRepository {
    private Map<String, User> users = new HashMap<>();

    User user = new User(1, "testuser", "password", "ROLE_USER");

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