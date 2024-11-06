package nat.superliga.crud.controllers;

import nat.superliga.crud.domain.Athlete.AthleteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/athlete")
public class AthleteController {
    @Autowired
    private AthleteRepository repository;

    @GetMapping
    public ResponseEntity getAllAthletes(){
        var allAthletes = repository.findAll();
        return ResponseEntity.ok(allAthletes);
    }
}