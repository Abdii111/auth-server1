package com.example.quoteeservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/quotee")
public class QuoteeController {

    @GetMapping("/random")
    public String getQuote() {
        return "Talk is cheap. Show me the code. - Linus Torvalds";
    }
}
