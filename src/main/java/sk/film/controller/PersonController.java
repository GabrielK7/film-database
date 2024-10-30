package sk.film.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.film.constant.RoleType;
import sk.film.dto.PersonDTO;
import sk.film.service.PersonService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class PersonController {
    @Autowired
    PersonService personService;

    @PostMapping({"/people/", "/people"})
    public PersonDTO addPerson(@RequestBody PersonDTO personDTO) {

        return personService.addPerson(personDTO);
    }

    @GetMapping(value = {"/actors", "/actors/"})
    public List<PersonDTO> getActors(@RequestParam(required = false, defaultValue = Integer.MAX_VALUE + "") int limit) {
        return personService.getPeople(RoleType.actor, limit);
    }

    @GetMapping(value = {"/directors", "/directors/"})
    public List<PersonDTO> getDirectors(@RequestParam(required = false, defaultValue = Integer.MAX_VALUE + "") int limit) {
        return personService.getPeople(RoleType.director, limit);
    }

    @GetMapping("/people/{personId}")
    public PersonDTO getPerson(@PathVariable Long personId) {
        return personService.getPerson(personId);
    }

    @PutMapping({"/people/{personId}", "/people/{personId}/"})
    public PersonDTO editPerson(@PathVariable Long personId, @RequestBody PersonDTO personDTO) {
        return personService.editPerson(personId, personDTO);
    }

    @DeleteMapping({"/people/{personId}", "/people/{personId}/"})
    public PersonDTO deletePerson(@PathVariable Long personId) {
        return personService.removePerson(personId);
    }
}
