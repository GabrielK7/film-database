package sk.film.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.film.dto.MovieDTO;
import sk.film.entity.filter.MovieFilter;
import sk.film.service.MovieService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class MovieController {
    @Autowired
    MovieService movieService;

    @GetMapping({"/genres", "/genres/"})
    public String[] getGenres() {
        return new String[]{"sci-fi", "adventure", "action", "romantic", "animated", "comedy"};
    }

    @PostMapping({"/movies/", "/movies"})
    public MovieDTO addMovie(@RequestBody MovieDTO movieDTO) {
        return movieService.addMovie(movieDTO);
    }

    @GetMapping({"/movies", "/movies/"})
    public List<MovieDTO> getAllMovies(MovieFilter movieFilter) {
        return movieService.getAllMovies(movieFilter);
    }

    @GetMapping({"/movies/{id}", "/movies/{id}/"})
    public MovieDTO getMovie(@PathVariable Long id) {
        return movieService.getMovie(id);
    }

    @PutMapping({"/movies/{id}", "/movies/{id}/"})
    public MovieDTO editMovie(@RequestBody MovieDTO movieDTO, @PathVariable long id) {
        return movieService.editMovie(movieDTO, id);
    }

    @DeleteMapping({"/movies/{id}", "/movies/{id}/"})
    public MovieDTO removeMovie(@PathVariable Long id) {
        return movieService.removeMovie(id);

    }
}
