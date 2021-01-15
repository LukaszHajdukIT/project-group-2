package com.example.demo.trainers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrainersInMemoryRepositoryTest {

    TrainerService trainerService = new TrainerService((new TrainersInMemoryRepository()));

    @Test
    public void shouldAddTrainer(){
        //when
        boolean result = trainerService.addTrainer(new TrainerDTO("Andrzej", "Andrzejewski", 93846738212L));
        //then
        assertEquals(true, result);
    }

    @Test
    public void shouldNotAddTrainerWithAlreadyPeselExists(){
        //given
        trainerService.addTrainer(new TrainerDTO("aaa", "aaa",93846738212L));
        //when
        boolean result = trainerService.addTrainer(new TrainerDTO("Andrzej", "Andrzejewski", 93846738212L));
        //then
        assertEquals(false, result);
    }

    @Test
    public void shouldNotAddTrainerWithToShortPesel(){
        //when
        boolean result = trainerService.addTrainer(new TrainerDTO("aaa", "aaa", 98475L));
        //then
       assertEquals(false, result);
    }

    @Test
    public void shouldNotAddTrainerWithToLongPesel(){
        //when
        boolean result = trainerService.addTrainer(new TrainerDTO("aaa", "aaa", 984753453456658768L));
        //then
        assertEquals(false, result);
    }
}