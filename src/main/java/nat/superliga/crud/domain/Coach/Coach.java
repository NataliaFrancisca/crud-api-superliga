package nat.superliga.crud.domain.Coach;

import jakarta.persistence.*;
import lombok.*;

@Table(name="coach")
@Entity(name="coach")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Coach {
    @Id @GeneratedValue(strategy = GenerationType.UUID)

    private String id;
    private String name;
    private String nationality;

    public Coach(CoachRequest requestCoach){
        this.name = requestCoach.name();
        this.nationality = requestCoach.nationality();
    }
}
