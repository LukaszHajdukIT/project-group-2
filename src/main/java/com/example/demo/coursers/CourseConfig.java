package com.example.demo.coursers;

import com.example.demo.courses.subcategory.SubcategoryRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
 class CourseConfig {
    @Bean
    CourseService courseService(CoursesRepository coursesRepository, SubcategoryRepository subcategoryRepository){
        return new CourseService(coursesRepository, subcategoryRepository);
    }
}
