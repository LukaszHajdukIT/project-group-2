package com.example.demo.trainers;

import org.springframework.data.repository.Repository;

import java.util.List;

interface TrainersRepository extends Repository<Trainer, Long> {
    List<Trainer> findTrainerByPesel (Long pesel);


    Trainer save(Trainer trainer);

    List<Trainer> findAll();
}
