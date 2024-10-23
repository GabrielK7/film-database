package sk.film.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.film.dto.PersonDTO;
import sk.film.service.PersonService;

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
}
