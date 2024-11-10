package sk.film.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.film.dto.MovieDTO;
import sk.film.dto.mapper.MovieMapper;
import sk.film.entity.MovieEntity;
import sk.film.entity.repository.MovieRepository;
import sk.film.entity.repository.PersonRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    PersonRepository personRepository;
    @Autowired
    MovieMapper movieMapper;

    @Override
    public MovieDTO addMovie(MovieDTO movieDTO) {
        MovieEntity movie = movieMapper.toEntity(movieDTO);
        movie.setActors(new ArrayList<>());
        for (Long actorId : movieDTO.getActorIDs()) {
            movie.getActors().add(personRepository.getReferenceById(actorId));
        }
        movie.setDirector(personRepository.getReferenceById(movieDTO.getDirectorID()));
        MovieEntity saved = movieRepository.save(movie);
        return movieMapper.toDTO(saved);
    }

    @Override
    public List<MovieDTO> getAllMovies() {
        List<MovieDTO> result = new ArrayList<>();
        for (MovieEntity movie : movieRepository.findAll()){
            result.add(movieMapper.toDTO(movie));
        }
        return result;
    }

    @Override
    public MovieDTO getMovie(Long id) {
        MovieEntity movie = movieRepository.getReferenceById(id);
        return movieMapper.toDTO(movie);
    }
}
