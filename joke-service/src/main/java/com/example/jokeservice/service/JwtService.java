package com.example.jokeservice.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;

@Service
public class JwtService {
    private final SecretKey secretKey = Keys.hmacShaKeyFor(
            "hemligtvärde1234567890hemligt1234".getBytes(StandardCharsets.UTF_8)
    );

    // Lägg till denna konstruktor för att logga nyckeln vid skapande av JwtService
    public JwtService() {
        System.out.println("Secret key: " +
                Base64.getEncoder().encodeToString(secretKey.getEncoded()));
    }

    public String extractUsername(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean isTokenValid(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(secretKey)
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            System.out.println("Token validation failed: " + e.getMessage());
            return false;
        }
    }
}