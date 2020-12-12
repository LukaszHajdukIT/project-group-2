package com.example.demo;

import com.example.demo.trainers.Trainer;
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
//			repository.save(new Trainer("Marcin", "Jasiński", (long) 28366372));

		for (Trainer trainer : repository.findAll())
			System.out.println(trainer.toString());

		});
	}



}
