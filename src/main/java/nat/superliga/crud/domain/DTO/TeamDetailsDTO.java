package nat.superliga.crud.domain.DTO;

import lombok.Getter;
import lombok.Setter;
import nat.superliga.crud.domain.Athlete.Athlete;
import nat.superliga.crud.domain.Coach.Coach;

import java.util.List;

@Getter
@Setter
public class TeamDetailsDTO {
    private String id;
    private String name;
    private String state;
    private Coach coach;
    private List<Athlete> athletes;
}
