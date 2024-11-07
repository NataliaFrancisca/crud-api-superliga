package nat.superliga.crud.controllers;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import nat.superliga.crud.domain.Athlete.*;
import nat.superliga.crud.domain.Team.Team;
import nat.superliga.crud.domain.Team.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
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

    private Optional<Team> getAthleteTeam(String team_id){
        return teamRepository.findById(team_id);
    }

    @GetMapping
    public ResponseEntity getAllAthletes(){
        List<Athlete> athletes = repository.findAll();
        List<AthleteDTO> athleteDTOS = athletes.stream().map(AthleteConverter::convertToDTO).toList();
        return ResponseEntity.ok(athleteDTOS);
    }

    @PostMapping
    public ResponseEntity setAthlete(@RequestBody @Valid RequestAthlete data){
        var team = getAthleteTeam(data.team_id());
        Athlete newAthlete = team.map(value -> new Athlete(data, value)).orElseGet(() -> new Athlete(data, null));

        repository.save(newAthlete);
        return ResponseEntity.ok("Athlete created successfully!");
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateAthlete(@RequestBody @Valid RequestAthlete data){
        Optional<Athlete> athleteOptional = repository.findById(data.id());

        if(athleteOptional.isEmpty()){
            throw new EntityNotFoundException();
        }

        Athlete athlete = athleteOptional.get();

        System.out.println(athlete);

        athlete.setName(data.name());
        athlete.setBirthdate(data.birthdate());
        athlete.setPosition(data.position());
        athlete.setHeight(data.height());
        athlete.setNationality(data.nationality());

        var team = getAthleteTeam(data.team_id());

        if(team.isEmpty()){
            athlete.setTeam(null);
        }else{
            athlete.setTeam(team.get());
        }

        return ResponseEntity.ok("Athlete updated successfully");
    }
}