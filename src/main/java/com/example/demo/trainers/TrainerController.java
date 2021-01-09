package com.example.demo.trainers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/trainers")
class TrainerController {

    private final TrainerService trainerService;

    TrainerController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @PostMapping
    ResponseEntity<Void> addTrainer(@RequestBody TrainerDTO trainerDTO) {
        if (trainerService.addTrainer(trainerDTO)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @GetMapping
    private List<TrainerDTO> getTrainers() {
        return trainerService.getTrainers();
    }
}
