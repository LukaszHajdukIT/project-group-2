package com.example.demo.trainers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrainersInMemoryRepositoryTest {

    TrainersRepository trainersRepository;

    TrainerService trainerService;

    @Test
    public void shouldAddTrainer(){
        //given
        trainerService = new TrainerService(new TrainersInMemoryRepository());
        //when
        boolean result = trainerService.addTrainer(new TrainerDTO("Andrzej", "Andrzejewski", 93846738212L));
        //then
        assertEquals(true, result);
    }

    @Test
    public void shouldNotAddTrainerWithAlreadyPeselExists(){
        //given
        trainerService = new TrainerService(new TrainersInMemoryRepository());
        trainerService.addTrainer(new TrainerDTO("aaa", "aaa",93846738212L));
        //when
        boolean result = trainerService.addTrainer(new TrainerDTO("Andrzej", "Andrzejewski", 93846738212L));
        //then
        assertEquals(false, result);
    }

    @Test
    public void shouldNotAddTrainerWithToShortPesel(){
        //given
        trainerService = new TrainerService(new TrainersInMemoryRepository());
        //when
        boolean result = trainerService.addTrainer(new TrainerDTO("aaa", "aaa", 98475L));
        //then
       assertEquals(false, result);
    }

    @Test
    public void shouldNotAddTrainerWithToLongPesel(){
        //given
        trainerService = new TrainerService(new TrainersInMemoryRepository());
        //when
        boolean result = trainerService.addTrainer(new TrainerDTO("aaa", "aaa", 984753453456658768L));
        //then
        assertEquals(false, result);
    }
}