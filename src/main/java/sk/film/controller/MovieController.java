package sk.film.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.film.dto.MovieDTO;
import sk.film.service.MovieService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class MovieController {
    @Autowired
    MovieService movieService;
    @GetMapping({"/genres", "/genres/"})
    public String[] getGenres(){
        return new String[] {"sci-fi", "adventure", "action", "romantic", "animated", "comedy"};
    }

    @PostMapping({"/movies/", "/movies"})
    public MovieDTO addMovie(@RequestBody MovieDTO movieDTO){
        return movieService.addMovie(movieDTO);
    }

    @GetMapping({"/movies", "/movies/"})
    public List<MovieDTO> getAllMovies(){
        return movieService.getAllMovies();
    }
    @GetMapping({"/movies/{id}", "/movies/{id}/"})
    public MovieDTO getMovie(@PathVariable Long id) {
        return movieService.getMovie(id);
    }
}
