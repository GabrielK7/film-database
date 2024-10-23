package sk.film.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.film.dto.PersonDTO;
import sk.film.dto.mapper.PersonMapper;
import sk.film.entity.PersonEntity;
import sk.film.entity.repository.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService{
    @Autowired
    PersonRepository personRepository;
    @Autowired
    PersonMapper personMapper;
    @Override
    public PersonDTO addPerson(PersonDTO personDTO) {
        PersonEntity entity = personMapper.toEntity(personDTO);
        PersonEntity savedEntity = personRepository.save(entity);
        return personMapper.toDTO(savedEntity);
    }
}
