package nat.superliga.crud.controllers;

import nat.superliga.crud.domain.Coach.CoachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
