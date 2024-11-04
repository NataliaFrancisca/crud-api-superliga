package nat.superliga.crud.domain.Coach;

import jakarta.validation.constraints.NotBlank;

public record CoachRequest(
        @NotBlank
        String id,
        @NotBlank
        String name,
        @NotBlank
        String nationality
){}
