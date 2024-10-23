package sk.film.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.film.entity.PersonEntity;

public interface PersonRepository extends JpaRepository<PersonEntity, Long> {
}
