package com.example.quoteeservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuoteController {

    @GetMapping("/quotes/random")
    public String getRandomQuote() {
        return "Life is what happens when you're busy making other plans. – John Lennon";
    }
}
