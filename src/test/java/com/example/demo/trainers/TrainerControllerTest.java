package com.example.demo.trainers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.Table;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TrainerControllerTest {

    @Autowired
    private TrainerController trainerController;

    @Autowired
    private TrainersRepository trainersRepository;

    @Autowired
    private TrainerService trainerService;

    @Test
    public void shouldShowTrainers() {
        //when
        trainerService.addTrainer(new TrainerDTO("Michał", "Witek", (long) 838383));
        //then
        assertEquals(1, trainersRepository.count());
    }
}
