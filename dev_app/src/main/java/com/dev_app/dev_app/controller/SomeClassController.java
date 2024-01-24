package com.dev_app.dev_app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SomeClassController {

        @GetMapping
        public ResponseEntity<String> sayHello() {
            return ResponseEntity.ok("Hello from secured endpoint");
        }
    }
