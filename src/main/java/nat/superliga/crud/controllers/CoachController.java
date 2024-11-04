package nat.superliga.crud.controllers;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import nat.superliga.crud.domain.Coach.Coach;
import nat.superliga.crud.domain.Coach.CoachRepository;
import nat.superliga.crud.domain.Coach.RequestCoach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @PutMapping
    @Transactional
    public ResponseEntity updateCoach(@RequestBody @Valid RequestCoach data){
        Optional<Coach> optionalCoach = repository.findById(data.id());

        if(optionalCoach.isEmpty()){
            throw new EntityNotFoundException();
        }

        Coach coach = optionalCoach.get();
        coach.setName(data.name());
        coach.setNationality(data.nationality());

        return ResponseEntity.ok("Coach updated successfully");
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteCoach(@PathVariable String id){
        Optional<Coach> optionalCoach = repository.findById(id);

        if(optionalCoach.isEmpty()){
            throw new EntityNotFoundException();
        }

        repository.delete(optionalCoach.get());
        return ResponseEntity.ok("Coach deleted successfully");
    }
}
