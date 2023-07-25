package com.dev_app.dev_app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dev_app.dev_app.model.ApiResponse;
import com.dev_app.dev_app.model.JwtAuthenticationResponse;
import com.dev_app.dev_app.model.LoginForm;
import com.dev_app.dev_app.model.User;
import com.dev_app.dev_app.repository.InMemoryUserRepository;
import com.dev_app.dev_app.security.JwtTokenProvider;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class AuthService {
    private InMemoryUserRepository userRepository;

    public ResponseEntity<?> login(LoginForm loginForm) {
        if (userRepository.existsByUsername(loginForm.getUsername())) {
            User user = userRepository.findByUsername(loginForm.getUsername());
            if (user.getPassword().equals(loginForm.getPassword())) {
                JwtAuthenticationResponse response = new JwtAuthenticationResponse(
                        JwtTokenProvider.generateToken(user.getUsername()));
                return ResponseEntity.ok(response);

            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(new ApiResponse(false, "Wrong username or password"));
    }
}
