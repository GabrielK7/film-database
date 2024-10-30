package sk.film.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import sk.film.dto.PersonDTO;

import java.util.Date;
import java.util.List;
@Entity(name="movie")
@Getter
@Setter
public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    private PersonEntity director;
    @ManyToMany
    @JoinTable(name = "actors",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id")

    )
    private List<PersonEntity> actors;
    private boolean isAvailable;
    @ElementCollection
    private List<String> genres;
    private Integer year;
    private Date dateAdded = new Date();

}
