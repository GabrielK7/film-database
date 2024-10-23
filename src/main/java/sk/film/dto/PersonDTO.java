package sk.film.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PersonDTO {
    @JsonProperty("_id")
    private long id;

    private String name;

    private Date birthDate;

    private String country;

    private String biography;

    private String role;

}
