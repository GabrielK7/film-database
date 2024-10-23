package sk.film.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Entity
@Getter
@Setter
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Date birthDate;
    private String country;
    @Column(columnDefinition = "TEXT", nullable = false)
    private  String biography;
    @Column(nullable = false)
    private String role;

}
