package com.example.demo.category;

import com.example.demo.models.Course;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DefaultCourseFacade implements CourseFacade {
    private CoursesRepository coursesRepository;

    public DefaultCourseFacade(CoursesRepository coursesRepository) {
        this.coursesRepository = coursesRepository;
    }

    public Optional<Course> getCoursesRepository(Long id) {
        return coursesRepository.findById(id);
    }
}