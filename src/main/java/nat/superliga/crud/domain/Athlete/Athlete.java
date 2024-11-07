package nat.superliga.crud.domain.Athlete;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import nat.superliga.crud.domain.Team.Team;

import java.time.LocalDate;

@Table(name="athlete")
@Entity(name="athlete")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Athlete {
    @Id @GeneratedValue(strategy = GenerationType.UUID)

    private String id;
    private String name;
    private String position;
    private Double height;
    private LocalDate birthdate;
    private String nationality;

    @ManyToOne
    @JoinColumn(name = "team_id")
    @JsonBackReference
    private Team team;

    public Athlete(RequestAthlete requestAthlete, Team team){
        this.name = requestAthlete.name();
        this.position = requestAthlete.position();
        this.height = requestAthlete.height();
        this.birthdate = requestAthlete.birthdate();
        this.nationality = requestAthlete.nationality();
        this.team = team;
    }
}
