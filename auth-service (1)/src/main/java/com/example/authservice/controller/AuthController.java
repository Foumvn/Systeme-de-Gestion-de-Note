package com.example.authservice.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @PostMapping("/login")
    public String login() {
        return "Token here (mock)";
    }

    @PostMapping("/register")
    public String register() {
        return "User registered (mock)";
    }
}