package nat.superliga.crud.domain.Athlete;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public record RequestAthlete (
        String id,
        @NotBlank String name,
        @NotBlank String position,
        @Positive Double height,
        @NotNull LocalDate birthdate,
        @NotBlank String nationality,
        @NotBlank String team_id,
        @NotBlank String photo
){}