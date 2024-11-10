package sk.film.service;

import sk.film.dto.MovieDTO;

import java.util.List;

public interface MovieService {
    MovieDTO addMovie(MovieDTO movieDTO);
    List<MovieDTO> getAllMovies();
    MovieDTO getMovie(Long id);

}
