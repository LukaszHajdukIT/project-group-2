package com.example.demo.trainers;

import java.util.ArrayList;
import java.util.List;

class TrainerService {

    private final TrainersRepository trainersRepository;

    TrainerService(TrainersRepository trainersRepository) {
        this.trainersRepository = trainersRepository;
    }

    boolean addTrainer(TrainerDTO trainerDTO) {

        if (trainerAlreadyExists(trainerDTO.getPesel())) {
            return false;
        } else if (peselLengthIsEqualToEleven(trainerDTO)) {
            trainersRepository.save(trainer(trainerDTO));
            return true;
        }
        return false;
    }

    private boolean peselLengthIsEqualToEleven(TrainerDTO trainerDTO) {
        return trainerDTO.getPesel().toString().length() == 11;
    }

    private boolean trainerAlreadyExists(Long trainerPesel) {
        return !trainersRepository.findTrainerByPesel(trainerPesel).isEmpty();
    }

    List<TrainerDTO> getTrainers() {
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
