package nat.superliga.crud.controllers;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import nat.superliga.crud.domain.Team.RequestTeam;
import nat.superliga.crud.domain.Team.Team;
import nat.superliga.crud.domain.Team.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/team")
public class TeamController {

    @Autowired
    private TeamRepository repository;

    @GetMapping
    public ResponseEntity getAllTeam(){
        var allTeams = repository.findAll();
        return ResponseEntity.ok(allTeams);
    }

    @PostMapping
    public ResponseEntity registerTeam(@RequestBody @Valid RequestTeam data){
        Team newTeam = new Team(data);
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
}
