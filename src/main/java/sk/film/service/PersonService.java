package sk.film.service;

import sk.film.constant.RoleType;
import sk.film.dto.PersonDTO;

import java.util.List;

public interface PersonService {

    PersonDTO addPerson(PersonDTO personDTO);
    List<PersonDTO> getPeople(RoleType roleType, int limit);
}
