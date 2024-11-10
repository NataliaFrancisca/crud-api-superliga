package nat.superliga.crud.domain.DTO;

import lombok.Getter;
import lombok.Setter;
import nat.superliga.crud.domain.Coach.Coach;

@Setter
@Getter
public class TeamSummaryDTO {
    private String id;
    private String name;
    private String state;
    private Coach coach;
}
