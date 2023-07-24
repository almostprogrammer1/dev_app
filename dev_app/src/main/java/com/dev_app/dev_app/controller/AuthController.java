package com.dev_app.dev_app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev_app.dev_app.model.ApiResponse;
import com.dev_app.dev_app.model.JwtAuthenticationResponse;
import com.dev_app.dev_app.model.LoginForm;
import com.dev_app.dev_app.model.User;
import com.dev_app.dev_app.repository.InMemoryUserRepository;
import com.dev_app.dev_app.security.JwtTokenProvider;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private InMemoryUserRepository userRepository;

    public AuthController(InMemoryUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginForm loginForm) {
        if (userRepository.existsByUsername(loginForm.getUsername())) {
            User user = userRepository.findByUsername(loginForm.getUsername());
            if (user.getPassword().equals(loginForm.getPassword())) {
                String jwt = JwtTokenProvider.generateToken(user.getUsername());
                JwtAuthenticationResponse response = new JwtAuthenticationResponse(jwt);
                return ResponseEntity.ok(response);
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(new ApiResponse(false, "Wrong username or password"));
    }
}