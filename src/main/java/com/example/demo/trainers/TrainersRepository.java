package com.example.demo.trainers;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface TrainersRepository extends JpaRepository<Trainer, Long> {
    List<Trainer> findTrainerByPesel (Long pesel);
}
