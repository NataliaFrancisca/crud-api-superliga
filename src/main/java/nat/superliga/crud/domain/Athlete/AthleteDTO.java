package nat.superliga.crud.domain.Athlete;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class AthleteDTO {
    private String id;
    private String name;
    private String position;
    private Double height;
    private LocalDate birthdate;
    private String nationality;
    private String teamId;
    private String photo;
}
