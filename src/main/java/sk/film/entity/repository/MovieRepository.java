package sk.film.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.film.entity.MovieEntity;

public interface MovieRepository extends JpaRepository<MovieEntity, Long> {

}
