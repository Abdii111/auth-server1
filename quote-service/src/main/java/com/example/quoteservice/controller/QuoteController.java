package com.example.quoteservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/quotes")
public class QuoteController {

    @GetMapping
    public List<String> getQuotes() {
        return List.of(
                "The only true wisdom is in knowing you know nothing.",
                "To be yourself in a world that is constantly trying to make you something else is the greatest accomplishment.",
                "Life is really simple, but we insist on making it complicated."
        );
    }
}
