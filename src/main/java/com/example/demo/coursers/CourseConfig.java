package com.example.demo.coursers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
 class CourseConfig {
    @Bean
    CourseService courseService(CoursesRepository coursesRepository){
        return new CourseService(coursesRepository);
    }
}
