package nat.superliga.crud.domain.Athlete;

public class AthleteConverter {
    public static AthleteDTO convertToDTO(Athlete athlete){
        AthleteDTO dto = new AthleteDTO();

        dto.setId(athlete.getId());
        dto.setName(athlete.getName());
        dto.setBirthdate(athlete.getBirthdate());
        dto.setHeight(athlete.getHeight());
        dto.setPosition(athlete.getPosition());
        dto.setNationality(athlete.getNationality());
        dto.setPhoto(athlete.getPhoto());

        if (athlete.getTeam() != null) {
            dto.setTeam_id(athlete.getTeam().getId());  // Atribui o ID do time ao DTO
        }

        return dto;
    }
}
