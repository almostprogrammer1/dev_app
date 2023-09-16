package com.dev_app.dev_app.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.dev_app.dev_app.entity.User;


public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
}
