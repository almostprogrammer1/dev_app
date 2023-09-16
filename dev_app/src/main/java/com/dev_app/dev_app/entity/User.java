package com.dev_app.dev_app.entity;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "users")

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class User {
// *********************************************************
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
// *********************************************************
    @NotBlank(message = "Email cannot be blank")
    @NonNull
    @Email
    @Column(nullable = false, unique = true)
    private String email;
// *********************************************************
    @NotBlank(message = "Username cannot be blank")
    @NonNull
    @Column(nullable = false, unique = true)
    private String username;
// *********************************************************
    @NotBlank(message = "Password cannot be blank")
    @NonNull
    @Column(nullable = false)
    private String password;
// *********************************************************
    
}
