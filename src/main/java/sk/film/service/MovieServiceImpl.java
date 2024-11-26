package sk.film.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import sk.film.dto.MovieDTO;
import sk.film.dto.mapper.MovieMapper;
import sk.film.entity.MovieEntity;
import sk.film.entity.filter.MovieFilter;
import sk.film.entity.repository.MovieRepository;
import sk.film.entity.repository.PersonRepository;
import sk.film.entity.repository.specification.MovieSpecification;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
    public List<MovieDTO> getAllMovies(MovieFilter movieFilter) {
        MovieSpecification movieSpecification = new MovieSpecification(movieFilter);

        return movieRepository.findAll(movieSpecification, PageRequest.of(0, movieFilter.getLimit()))
                .stream()
                .map(movieMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MovieDTO getMovie(Long id) {
        MovieEntity movie = movieRepository.getReferenceById(id);
        System.out.println(movie.getDirector().toString());
        return movieMapper.toDTO(movie);

    }

    @Override
    public MovieDTO editMovie(MovieDTO movieDTO, long id) {
        movieDTO.setId(id);
        MovieEntity entity = movieRepository.getReferenceById(id);
        movieMapper.updateEntity(movieDTO, entity);

        entity.setActors(new ArrayList<>());
        for (Long actorId : movieDTO.getActorIDs()) {
            entity.getActors().add(personRepository.getReferenceById(actorId));
        }
        entity.setDirector(personRepository.getReferenceById(movieDTO.getDirectorID()));
        MovieEntity saved = movieRepository.save(entity);
        return movieMapper.toDTO(saved);
    }

    @Override
    public MovieDTO removeMovie(Long id) {
        MovieEntity movie = movieRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        MovieDTO model = movieMapper.toDTO(movie);
        movieRepository.delete(movie);
        return model;
    }
}
