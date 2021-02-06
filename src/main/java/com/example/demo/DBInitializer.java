package com.example.demo;

import com.example.demo.category.Category;
import com.example.demo.category.CategoryRepository;
import com.example.demo.coursers.Course;
import com.example.demo.coursers.CoursesRepository;
import com.example.demo.courses.subcategory.Subcategory;
import com.example.demo.courses.subcategory.SubcategoryRepository;
import com.example.demo.trainers.TrainersRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Profile("prod")
public class DBInitializer implements CommandLineRunner {

    private CategoryRepository categoryRepository;
    private CoursesRepository coursesRepository;
    private SubcategoryRepository subcategoryRepository;
    private TrainersRepository trainersRepository;

    public DBInitializer(CategoryRepository categoryRepository, CoursesRepository coursesRepository, SubcategoryRepository subcategoryRepository, TrainersRepository trainersRepository) {
        this.categoryRepository = categoryRepository;
        this.coursesRepository = coursesRepository;
        this.subcategoryRepository = subcategoryRepository;
        this.trainersRepository = trainersRepository;
    }

    public void run(String... args) throws Exception {
        Category it = new Category("IT", "IT description");
        Category sales = new Category("Sales", "Sales description");
        Category marketing = new Category("Marketing", "Marketing description");
        Category other = new Category("Other", "Other description");
        categoryRepository.save(it);
        categoryRepository.save(sales);
        categoryRepository.save(marketing);
        categoryRepository.save(other);

        Subcategory java = new Subcategory("Java", "Java description", it);
        Subcategory cSharp = new Subcategory("C#", "C# description", it);
        Subcategory javaScript = new Subcategory("JavaScript", "JavaScript description", it);
        Subcategory devOps = new Subcategory("DevOps", "DevOps description", it);
        Subcategory dotNet = new Subcategory(".Net", ".Net description", it);
        subcategoryRepository.save(java);
        subcategoryRepository.save(cSharp);
        subcategoryRepository.save(javaScript);
        subcategoryRepository.save(devOps);
        subcategoryRepository.save(dotNet);

        Course basicsJava = new Course("Basics", "Basics description", 8, java);
        Course basicsCSharp = new Course("Basics", "Basics description", 8, cSharp);
        Course basicsDevOps = new Course("Basics", "Basics description", 8, devOps);
        Course basicsJS = new Course("Basics", "Basics description", 8, javaScript);
        Course angular = new Course("Angular", "Angular description", 8, javaScript);
        Course react = new Course("React", "React description", 8, javaScript);
        Course redux = new Course("Redux", "Redux description", 8, javaScript);
        Course basicsDotNet = new Course("Basics", "Basics description", 8, dotNet);
        coursesRepository.save(basicsJava);
        coursesRepository.save(basicsCSharp);
        coursesRepository.save(basicsDevOps);
        coursesRepository.save(basicsJS);
        coursesRepository.save(angular);
        coursesRepository.save(react);
        coursesRepository.save(redux);
        coursesRepository.save(basicsDotNet);

        coursesRepository.findAll().forEach(System.out::println);
    }
}
