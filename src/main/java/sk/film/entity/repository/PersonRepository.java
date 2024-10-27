package sk.film.entity.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sk.film.constant.RoleType;
import sk.film.entity.PersonEntity;

import java.util.List;

public interface PersonRepository extends JpaRepository<PersonEntity, Long> {
   Page<PersonEntity> getAllByRole(RoleType role, Pageable page);
   // @Query(value = "SELECT * FROM person_entity WHERE role= :#{#role.name()} LIMIT :limit", nativeQuery = true)
    //List<PersonEntity> getAllByRole(@Param("role") RoleType role,@Param("limit") int limit);
}
