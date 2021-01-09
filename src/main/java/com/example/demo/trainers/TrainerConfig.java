package com.example.demo.trainers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class TrainerConfig {

    @Bean
    TrainerService trainerService(TrainersRepository trainersRepository){
        return new TrainerService(trainersRepository);
    }
}
