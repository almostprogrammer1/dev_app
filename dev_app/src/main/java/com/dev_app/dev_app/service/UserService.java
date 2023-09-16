package com.dev_app.dev_app.service;

import com.dev_app.dev_app.entity.User;

public interface UserService {
    User getUser(Long id);
    User getUser(String username);
    User getUserByEmail(String email);
    User saveUser(User user);
    
}
