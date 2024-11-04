package nat.superliga.crud.controllers;

import jakarta.validation.Valid;
import nat.superliga.crud.domain.Coach.Coach;
import nat.superliga.crud.domain.Coach.CoachRepository;
import nat.superliga.crud.domain.Coach.RequestCoach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/coach")
public class CoachController {
    @Autowired
    private CoachRepository repository;

    @GetMapping
    public ResponseEntity getAllCoach(){
        var allCoaches = repository.findAll();
        return ResponseEntity.ok(allCoaches);
    }

    @PostMapping
    public ResponseEntity registerCoach(@RequestBody @Valid RequestCoach data){
        Coach newCoach = new Coach(data);
        repository.save(newCoach);
        return ResponseEntity.ok("Coach created successfully!");
    }
}
