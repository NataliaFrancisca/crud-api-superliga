package nat.superliga.crud.controllers;

import jakarta.validation.Valid;
import nat.superliga.crud.domain.Athlete.*;
import nat.superliga.crud.domain.Team.Team;
import nat.superliga.crud.domain.Team.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/athlete")
public class AthleteController {

    @Autowired
    private AthleteRepository repository;
    @Autowired
    private TeamRepository teamRepository;

    @GetMapping
    public ResponseEntity getAllAthletes(){
        List<Athlete> athletes = repository.findAll();
        List<AthleteDTO> athleteDTOS = athletes.stream().map(AthleteConverter::convertToDTO).toList();
        return ResponseEntity.ok(athleteDTOS);
    }

    @PostMapping
    public ResponseEntity setAthlete(@RequestBody @Valid RequestAthlete data){
        Optional<Team> teamOptional = teamRepository.findById(data.team_id());

        Athlete newAthlete = teamOptional.map(team -> new Athlete(data, team)).orElseGet(() -> new Athlete(data, null));
        repository.save(newAthlete);

        return ResponseEntity.ok("Athlete created successfully!");
    }
}