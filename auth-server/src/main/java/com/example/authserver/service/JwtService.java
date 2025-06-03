package com.example.authserver.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.List;

@Service
public class JwtService {

    // Exakt 32 tecken (256 bit)
    private final String secretString = "hemligtvärde1234567890hemligt1234";
    private final SecretKey key = Keys.hmacShaKeyFor(secretString.getBytes());

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .claim("authorities", List.of("SCOPE_jokes.read"))
                .claim("authorities", List.of("SCOPE_quotee.read"))
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1h
                .signWith(key)
                .compact();
    }


}
