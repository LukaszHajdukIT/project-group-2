package com.example.demo.trainers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trainers")
public class TrainerController {

    private final TrainerService trainerService;

    public TrainerController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

   @PostMapping
    public void addTrainer(@RequestBody TrainerDTO trainerDTO) {
        trainerService.addTrainer(trainerDTO);
    }


}
