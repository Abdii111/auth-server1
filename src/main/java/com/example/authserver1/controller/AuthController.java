package com.example.authserver1.controller;

import com.example.authserver1.model.LoginRequest;
import com.example.authserver1.service.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtService jwtService;

    public AuthController(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        // Hårdkodad användare (för nu)
        if ("user".equals(request.getUsername()) && "password".equals(request.getPassword())) {
            String token = jwtService.generateToken(request.getUsername());
            return ResponseEntity.ok().body(token);
        } else {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }
}