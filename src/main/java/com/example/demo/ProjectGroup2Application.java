package com.example.demo;

import com.example.demo.coursers.Courses;
import com.example.demo.coursers.CoursesRepository;
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
	public CommandLineRunner addCourses(CoursesRepository repository){
		return (args -> {
			repository.save(new Courses("Java", "Java Basics"));

			for (Courses course : repository.findAll()){
				System.out.println(course.toString());
			}
		});
	}
}
