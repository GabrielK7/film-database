package sk.film.entity.repository.specification;

import jakarta.persistence.criteria.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import sk.film.entity.MovieEntity;
import sk.film.entity.MovieEntity_;
import sk.film.entity.PersonEntity;
import sk.film.entity.PersonEntity_;
import sk.film.entity.filter.MovieFilter;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class MovieSpecification implements Specification<MovieEntity> {
    private final MovieFilter movieFilter;


    @Override
    public Predicate toPredicate(Root<MovieEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();

        if (movieFilter.getFromYear() != null) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get(MovieEntity_.YEAR), movieFilter.getFromYear()));
        }

        if (movieFilter.getToYear() != null) {
            predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get(MovieEntity_.YEAR), movieFilter.getToYear()));
        }
        if (movieFilter.getDirectorID() != null) {
            Join<PersonEntity, MovieEntity> directorJoin = root.join(MovieEntity_.DIRECTOR);
            predicates.add(criteriaBuilder.equal(directorJoin.get(PersonEntity_.ID), movieFilter.getDirectorID()));
        }
        if (movieFilter.getActorID() != null) {
            Join<PersonEntity, MovieEntity> actorJoin = root.join(MovieEntity_.ACTORS);
            predicates.add(actorJoin.get(PersonEntity_.ID).in(movieFilter.getActorID()));
        }
        if (movieFilter.getGenre() != null) {
            Expression<String> genreJoin = root.join(MovieEntity_.GENRES);
            predicates.add(genreJoin.in(movieFilter.getGenre()));
        }
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
