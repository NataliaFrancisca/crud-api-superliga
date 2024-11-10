package nat.superliga.crud.domain.Team;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import nat.superliga.crud.domain.Athlete.Athlete;
import nat.superliga.crud.domain.Coach.Coach;

import java.util.List;

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

    @OneToMany(mappedBy = "team")
    @JsonManagedReference
    private List<Athlete> atheletes;

    @OneToOne
    @JoinColumn(name = "coach_id", insertable=false, updatable=false)
    private Coach coach;

    public Team(RequestTeam requestTeam, Coach coach){
        this.name = requestTeam.name();
        this.coach_id = requestTeam.coach_id();
        this.state = requestTeam.state();
        this.coach = coach;
    }
}
