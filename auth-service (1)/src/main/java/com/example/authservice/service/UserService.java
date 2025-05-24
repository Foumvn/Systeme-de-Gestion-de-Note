package com.example.authservice.service;

import com.example.authservice.dto.AuthRequest;
import com.example.authservice.dto.AuthResponse;
import com.example.authservice.dto.RegisterRequest;
import com.example.authservice.model.User;
import com.example.authservice.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private final Map<String, User> users = new HashMap<>();
    
    @Autowired
    private JwtUtil jwtUtil;

    public void registerUser(RegisterRequest request) {
        users.put(request.getUsername(), 
            new User(request.getUsername(), request.getPassword()));
    }

    public AuthResponse authenticate(AuthRequest request) {
        User user = users.get(request.getUsername());
        if (user != null && user.getPassword().equals(request.getPassword())) {
            String token = jwtUtil.generateToken(user.getUsername());
            return new AuthResponse(token);
        }
        throw new RuntimeException("Invalid credentials");
    }
}