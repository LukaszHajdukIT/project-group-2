package com.example.demo.trainers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trainer")
public class TrainerController {

    TrainerService trainerService;

    @PostMapping
    public void addTrainer(@RequestBody TrainerDTO trainerDTO){
    trainerService.addTrainer(trainerDTO);
    }
}
