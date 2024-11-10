package nat.superliga.crud.domain.Team;

import nat.superliga.crud.domain.DTO.TeamSummaryDTO;
import nat.superliga.crud.domain.DTO.TeamDetailsDTO;

public class TeamConverter {
    public static TeamDetailsDTO convertToFullDTO(Team team){
        TeamDetailsDTO dto = new TeamDetailsDTO();

        dto.setId(team.getId());
        dto.setName(team.getName());
        dto.setState(team.getState());
        dto.setAthletes(team.getAtheletes());

        if(team.getCoach() != null){
            dto.setCoach(team.getCoach());
        }

        return dto;
    }

    public static TeamSummaryDTO convertToBasicDTO(Team team){
        TeamSummaryDTO dto = new TeamSummaryDTO();

        dto.setId(team.getId());
        dto.setName(team.getName());
        dto.setState(team.getState());

        if(team.getCoach() != null){
            dto.setCoach(team.getCoach());
        }

        return dto;
    }
}
