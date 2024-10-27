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
    public List<PersonDTO> getActors(@RequestParam int limit){
return  personService.getPeople(RoleType.actor, limit);
    }

    @GetMapping(value = {"/directors", "/directors/"})
    public List<PersonDTO> getDirectors(@RequestParam int limit){
        return  personService.getPeople(RoleType.director, limit);
    }
}
