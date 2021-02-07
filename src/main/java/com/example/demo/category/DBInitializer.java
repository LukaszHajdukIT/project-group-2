package com.example.demo.category;

import com.example.demo.models.Category;
import com.example.demo.models.Course;
import com.example.demo.models.Subcategory;
import com.example.demo.trainers.TrainersRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("prod")
 class DBInitializer implements CommandLineRunner {

    private CategoryRepository categoryRepository;
    private CoursesRepository coursesRepository;
    private SubcategoryRepository subcategoryRepository;
    private TrainersRepository trainersRepository;

     DBInitializer(CategoryRepository categoryRepository, CoursesRepository coursesRepository, SubcategoryRepository subcategoryRepository, TrainersRepository trainersRepository) {
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

        Course basicsJava = new Course("Java Basics", "Java Basics for beginners", 8, java);
        Course intermediateJava = new Course("Java Intermediate", "Java for intermediate users", 8, java);
        Course expertJava = new Course("Java Expert", "Java for experts", 8, java);

        Course basicsCSharp = new Course("C# Basics", "C# Basics for beginners", 8, cSharp);
        Course intermediateCSharp = new Course("C# Intermediate", "C# for intermediate users", 8, cSharp);
        Course expertCSharp = new Course("C# Expert", "C# for experts", 8, cSharp);

        Course basicsDevOps = new Course("DevOps Basics", "DevOps Basics for beginners", 8, devOps);
        Course intermediateDevOps = new Course("DevOps Intermediate", "DevOps for intermediate users", 8, devOps);
        Course expertDevOps = new Course("DevOps Expert", "DevOps for experts", 8, devOps);

        Course basicsJS = new Course("JavaScript Basics", "JavaScript Basics for beginners", 8, javaScript);
        Course angular = new Course("Angular", "Angular for intermediate users", 8, javaScript);
        Course react = new Course("React", "React for intermediate users", 8, javaScript);
        Course redux = new Course("Redux", "Redux for intermediate users", 8, javaScript);

        Course basicsDotNet = new Course(".NET Basics", ".NET Basics for beginners", 8, dotNet);
        Course dotNetCore = new Course(".NET Core", ".NET Core for intermediate users", 8, dotNet);
        Course aspDotNet = new Course("ASP.NET", "ASP.NET for intermediate users", 8, dotNet);

        coursesRepository.save(basicsJava);
        coursesRepository.save(intermediateJava);
        coursesRepository.save(expertJava);

        coursesRepository.save(basicsCSharp);
        coursesRepository.save(intermediateCSharp);
        coursesRepository.save(expertCSharp);

        coursesRepository.save(basicsDevOps);
        coursesRepository.save(intermediateDevOps);
        coursesRepository.save(expertDevOps);

        coursesRepository.save(basicsJS);
        coursesRepository.save(angular);
        coursesRepository.save(react);
        coursesRepository.save(redux);

        coursesRepository.save(basicsDotNet);
        coursesRepository.save(dotNetCore);
        coursesRepository.save(aspDotNet);

        coursesRepository.findAll().forEach(System.out::println);
    }
}