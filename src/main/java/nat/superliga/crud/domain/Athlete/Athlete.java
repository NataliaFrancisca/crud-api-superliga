package nat.superliga.crud.domain.Athlete;

import jakarta.persistence.*;
import lombok.*;
import nat.superliga.crud.domain.Team.Team;

@Table(name="athlete")
@Entity(name="athlete")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Athlete {
    @Id @GeneratedValue(strategy = GenerationType.UUID)

    private String name;
    private String position;
    private Double height;
    private Integer age;
    private String nationality;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    public Athlete(RequestAthlete requestAthlete){
        this.name = requestAthlete.name();
        this.position = requestAthlete.position();
        this.height = requestAthlete.height();
        this.age = requestAthlete.age();
        this.nationality = requestAthlete.nationality();
    }
}
