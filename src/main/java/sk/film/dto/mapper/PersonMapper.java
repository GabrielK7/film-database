package sk.film.dto.mapper;


import org.mapstruct.Mapper;
import sk.film.dto.PersonDTO;
import sk.film.entity.PersonEntity;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    PersonEntity toEntity(PersonDTO source);
    PersonDTO toDTO(PersonEntity source);
}
