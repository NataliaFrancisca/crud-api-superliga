package nat.superliga.crud.controllers;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import nat.superliga.crud.domain.Coach.Coach;
import nat.superliga.crud.domain.Coach.CoachRepository;
import nat.superliga.crud.domain.DTO.TeamSummaryDTO;
import nat.superliga.crud.domain.Team.*;
import nat.superliga.crud.domain.DTO.TeamDetailsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/team")
public class TeamController {

    @Autowired
    private TeamRepository repository;
    @Autowired
    private CoachRepository coachRepository;

    private Optional<Coach> getTeamCoach(String coach_id) {
        return coachRepository.findById(coach_id);
    }

    @GetMapping
    public ResponseEntity getAllTeam(){
        List<TeamSummaryDTO> teams = repository.findAll()
            .stream()
            .map(TeamConverter::convertToBasicDTO)
            .toList();
        return ResponseEntity.ok(teams);
    }

    @GetMapping("/{id}")
    public ResponseEntity getTeam(@PathVariable String id){
        Team team = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        TeamDetailsDTO teamDTO = TeamConverter.convertToFullDTO(team);
        return ResponseEntity.ok(teamDTO);
    }

    @PostMapping
    public ResponseEntity registerTeam(@RequestBody @Valid RequestTeam data){
        var coach = getTeamCoach(data.coach_id());
        Team newTeam = coach.map(value -> new Team(data, value)).orElseGet(() -> new Team(data, null));

        repository.save(newTeam);
        return ResponseEntity.ok("Team created successfully");
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateTeam(@RequestBody @Valid RequestTeam data){
        Optional<Team> optionalTeam = repository.findById(data.id());

        if(optionalTeam.isEmpty()){
            throw new EntityNotFoundException();
        }

        Team team = optionalTeam.get();
        team.setName(data.name());
        team.setState(data.state());
        team.setCoach_id(data.coach_id());

        return ResponseEntity.ok("Team updated successfully");
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteCoach(@PathVariable String id){
        Optional<Team> optionalTeam = repository.findById(id);

        if(optionalTeam.isEmpty()){
            throw new EntityNotFoundException();
        }

        repository.delete(optionalTeam.get());
        return ResponseEntity.ok("Team deleted successfully");
    }
}
