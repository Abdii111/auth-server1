package com.example.jokeservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/jokes")
public class JokeController {

    @GetMapping("/random")
    public String getJoke() {
        return "Why do Java developers wear glasses? Because they don't C#.";
    }
}

