package com.example.demo;

import com.example.demo.category.Category;
import com.example.demo.category.CategoryRepository;
import com.example.demo.coursers.Course;
import com.example.demo.coursers.CoursesRepository;
import com.example.demo.courses.subcategory.Subcategory;
import com.example.demo.courses.subcategory.SubcategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectGroup2Application implements CommandLineRunner {

	@Autowired
	private SubcategoryRepository subcategoryRepository;

	@Autowired
	private CoursesRepository coursesRepository;

	@Autowired
	CategoryRepository categoryRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProjectGroup2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Category it = new Category("nameIT", "descriptionIT");
		Category it2 = new Category("nameIT2", "descriptionIT2");
		categoryRepository.save(it);
		categoryRepository.save(it2);

		Subcategory java = new Subcategory("Java", "description", it);
		Subcategory javaScript = new Subcategory("JavaScript", "description", it2);
		subcategoryRepository.save(java);
		subcategoryRepository.save(javaScript);

		Course java2 = new Course("Java2", "description", 8, java);
		Course java3 = new Course("Java3", "description", 8, java);
		Course java4 = new Course("Java4", "description", 8, java);
		Course javaScript2 = new Course("JavaScript2", "description", 8, javaScript);
		Course javaScript3 = new Course("JavaScript3", "description", 8, javaScript);
		coursesRepository.save(java2);
		coursesRepository.save(java3);
		coursesRepository.save(java4);
		coursesRepository.save(javaScript2);
		coursesRepository.save(javaScript3);
	}
}
