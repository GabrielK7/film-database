package sk.film.service;

import org.springframework.stereotype.Service;
import sk.film.dto.MovieDTO;
import sk.film.entity.filter.MovieFilter;

import java.util.List;
public interface MovieService {
    MovieDTO addMovie(MovieDTO movieDTO);
    List<MovieDTO> getAllMovies(MovieFilter movieFilter);
    MovieDTO getMovie(Long id);
    MovieDTO editMovie(MovieDTO movieDTO, long id);
    MovieDTO removeMovie(Long id);
}
