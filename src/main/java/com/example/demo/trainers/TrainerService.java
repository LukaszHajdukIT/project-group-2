package com.example.demo.trainers;

import org.springframework.context.annotation.Configuration;

@Configuration
public class TrainerService {

    private final TrainersRepository trainersRepository;

    public TrainerService(TrainersRepository trainersRepository) {
        this.trainersRepository = trainersRepository;
    }

    public void addTrainer(TrainerDTO trainerDTO) {
        trainersRepository.save(trainer(trainerDTO));
    }

    private Trainer trainer(TrainerDTO trainerDTO) {
        Trainer trainer = new Trainer();
        trainer.setId(trainerDTO.getId());
        trainer.setFirstName(trainerDTO.getFirstName());
        trainer.setLastName(trainerDTO.getLastName());
        trainer.setPesel(trainerDTO.getPesel());
        return trainer;
    }
}
