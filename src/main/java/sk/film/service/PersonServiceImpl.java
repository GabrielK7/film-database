package sk.film.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import sk.film.constant.RoleType;
import sk.film.dto.PersonDTO;
import sk.film.dto.mapper.PersonMapper;
import sk.film.entity.PersonEntity;
import sk.film.entity.repository.PersonRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
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

    @Override
    public List<PersonDTO> getPeople(RoleType roleType, int limit) {
        Page<PersonEntity> pageOfPeople = personRepository.getAllByRole(roleType, PageRequest.of(0, limit));
        List<PersonEntity> personEntities = pageOfPeople.getContent();

        // List<PersonEntity> personEntities = personRepository.getAllByRole(roleType, limit);

        List<PersonDTO> result = new ArrayList<>();
        for (PersonEntity e : personEntities) {
            result.add(personMapper.toDTO(e));
        }
        return result;
    }

    @Override
    public PersonDTO getPerson(Long personId) {
        PersonEntity person = personRepository.getReferenceById(personId);
        return personMapper.toDTO(person);
    }

    @Override
    public PersonDTO editPerson(Long personId, PersonDTO personDTO) {
        if (!personRepository.existsById(personId)) {
            throw new EntityNotFoundException("Person with id " + personId + "wasn't found in the database.");
        }
        PersonEntity personEntity = personMapper.toEntity(personDTO);
        personEntity.setId(personId);
        PersonEntity saved = personRepository.save(personEntity);
        return personMapper.toDTO(saved);
    }

    @Override
    public PersonDTO removePerson(Long personId) {
        PersonEntity person = personRepository.findById(personId).orElseThrow(EntityNotFoundException::new);
        PersonDTO model = personMapper.toDTO(person);
        personRepository.delete(person);
        return model;
    }


}
