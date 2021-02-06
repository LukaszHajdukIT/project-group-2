package com.example.demo.category;

import com.example.demo.models.Course;

import java.util.Optional;

public class InMemoryCourseFacade implements CourseFacade{
    private final CoursesRepository coursesRepository;

    public InMemoryCourseFacade(CoursesRepository coursesRepository) {
        this.coursesRepository = coursesRepository;
    }

    @Override
    public Optional<Course> getCoursesRepository(Long id) {
        return coursesRepository.findById(id);
    }
}
