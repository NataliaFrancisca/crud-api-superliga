package nat.superliga.crud.domain.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import nat.superliga.crud.domain.Coach.Coach;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TeamSummaryDTO {
    private String id;
    private String name;
    private String state;
    private Coach coach;
}
