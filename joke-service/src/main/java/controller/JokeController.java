package controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JokeController {

    @GetMapping("/api/jokes/random")
    public String getJoke() {
        return "Why don't programmers like nature? It has too many bugs.";
    }
}