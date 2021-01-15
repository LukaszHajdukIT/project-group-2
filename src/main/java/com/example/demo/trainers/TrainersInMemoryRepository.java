package com.example.demo.trainers;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class TrainersInMemoryRepository implements TrainersRepository {

    Map<Long, Trainer> trainers = new ConcurrentHashMap<>();

    @Override
    public List<Trainer> findTrainerByPesel(Long pesel) {
        return trainers.values().stream()
                .filter(trainer -> trainer.getPesel().equals(pesel))
                .collect(Collectors.toList());
    }

    @Override
    public Trainer save(Trainer trainer) {
        long elementsCount = trainers.size();
        trainers.put(elementsCount, trainer);
        return trainer;
    }

    @Override
    public List<Trainer> findAll() {
       return new ArrayList<>(trainers.values());
    }
}
