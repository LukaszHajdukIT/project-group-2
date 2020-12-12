package com.example.demo;

import com.example.demo.trainers.Trainers;
import com.example.demo.trainers.TrainersRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProjectGroup2Application {

	public static void main(String[] args) {
		SpringApplication.run(ProjectGroup2Application.class, args);
	}

	@Bean
	public CommandLineRunner addTrainers(TrainersRepository repository){
		return (args -> {
			repository.save(new Trainers("Marcin", "Jasiński", 123456789));
		});
	}



}
