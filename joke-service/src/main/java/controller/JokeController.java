package controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/jokes")
public class JokeController {

    @GetMapping("/random")
    public String getJoke() {
        return "Why don't programmers like nature? It has too many bugs.";
    }
}