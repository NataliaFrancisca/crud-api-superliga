package nat.superliga.crud.domain.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import nat.superliga.crud.domain.Athlete.Athlete;
import nat.superliga.crud.domain.Coach.Coach;

import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TeamDetailsDTO {
    private String id;
    private String name;
    private String state;
    private Coach coach;
    private List<Athlete> athletes;
}
