package sk.film.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class MovieController {
    @GetMapping({"/genres", "/genres/"})
    public String[] getGenres(){
        return new String[] {"sci-fi", "adventure", "action", "romantic", "animated", "comedy"};
    }
}
