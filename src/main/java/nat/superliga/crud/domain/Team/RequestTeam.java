package nat.superliga.crud.domain.Team;

import jakarta.validation.constraints.NotBlank;

public record RequestTeam(
        String id,
        @NotBlank
        String name,
        String coach_id,
        @NotBlank
        String state
) {
}
