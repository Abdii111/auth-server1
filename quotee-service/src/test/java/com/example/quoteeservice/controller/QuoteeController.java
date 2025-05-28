package com.example.quoteeservice.controller;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@SpringBootTest
@RestController
@RequestMapping("/api/quotes")
public class QuoteeController {

    private static final List<String> QUOTES = List.of(
            "The only way to do great work is to love what you do. – Steve Jobs",
            "Innovation distinguishes between a leader and a follower. – Steve Jobs",
            "Life is what happens when you're busy making other plans. – John Lennon"
    );

    private final Random random = new Random();

    @GetMapping("/random")
    public String getRandomQuote() {
        return QUOTES.get(random.nextInt(QUOTES.size()));
    }
}