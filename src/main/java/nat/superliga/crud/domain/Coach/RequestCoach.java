package nat.superliga.crud.domain.Coach;

import jakarta.validation.constraints.NotBlank;

public record RequestCoach(
        String id,
        @NotBlank
        String name,
        @NotBlank
        String nationality
){}
