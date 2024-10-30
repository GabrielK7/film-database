package sk.film.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import sk.film.dto.MovieDTO;
import sk.film.entity.MovieEntity;
@Mapper(componentModel = "spring")
public interface MovieMapper {
    @Mapping(target = "dateAdded", ignore = true)
    @Mapping(target = "actors", ignore = true)
    @Mapping(target = "director", ignore = true)
    MovieEntity toEntity(MovieDTO source);
    @Mapping(target = "dateAdded", ignore = true)
    @Mapping(target = "actors", ignore = true)
    @Mapping(target = "director", ignore = true)
    MovieDTO toDTO(MovieEntity source);
    MovieEntity updateEntity(MovieDTO source, @MappingTarget MovieEntity target);
}
