package com.example.demo.trainers;

import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class TrainerService {

    private final TrainersRepository trainersRepository;

    public TrainerService(TrainersRepository trainersRepository) {
        this.trainersRepository = trainersRepository;
    }

    public boolean addTrainer(TrainerDTO trainerDTO) {
        if (trainerAlreadyExists(trainerDTO.getPesel())) {
            return false;
        } else {
            trainersRepository.save(trainer(trainerDTO));
            return true;
        }
    }

    private boolean trainerAlreadyExists(Long trainerName) {
        return !trainersRepository.findTrainerByPesel(trainerName).isEmpty();
    }

    public List<TrainerDTO> getTrainers() {
        List<Trainer> allTrainers = trainersRepository.findAll();
        List<TrainerDTO> allTrainersDTO = new ArrayList<>();
        for (Trainer trainer : allTrainers) {
            TrainerDTO trainerDTO = trainerDTO(trainer);
            allTrainersDTO.add(trainerDTO);
        }
        return allTrainersDTO;
    }

    private Trainer trainer(TrainerDTO trainerDTO) {
        Trainer trainer = new Trainer();
        trainer.setId(trainerDTO.getId());
        trainer.setFirstName(trainerDTO.getFirstName());
        trainer.setLastName(trainerDTO.getLastName());
        trainer.setPesel(trainerDTO.getPesel());
        return trainer;
    }

    private TrainerDTO trainerDTO(Trainer trainer) {
        TrainerDTO trainerDTO = new TrainerDTO();
        trainerDTO.setId(trainer.getId());
        trainerDTO.setFirstName(trainer.getFirstName());
        trainerDTO.setLastName(trainer.getLastName());
        trainerDTO.setPesel(trainer.getPesel());
        return trainerDTO;
    }
}
