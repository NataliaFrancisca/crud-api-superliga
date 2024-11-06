package nat.superliga.crud.domain.Athlete;

import jakarta.validation.constraints.NotBlank;

public record RequestAthlete (
        String id,
        @NotBlank
        String name,
        @NotBlank
        String position,
        @NotBlank
        Double height,
        @NotBlank
        Integer age,
        @NotBlank
        String nationality,
        @NotBlank
        String team_id
){}