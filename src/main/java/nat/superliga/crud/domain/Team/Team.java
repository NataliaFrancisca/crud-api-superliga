package nat.superliga.crud.domain.Team;

import jakarta.persistence.*;
import lombok.*;

@Table(name="team")
@Entity(name="team")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Team {
    @Id @GeneratedValue(strategy = GenerationType.UUID)

    private String id;
    private String name;
    private String coach_id;
    private String state;

    public Team(RequestTeam requestTeam){
        this.name = requestTeam.name();
        this.coach_id = requestTeam.coach_id();
        this.state = requestTeam.state();
    }
}
