package com.example.demo.category;

import com.example.demo.models.Course;

import java.util.Optional;

public interface CourseFacade {
    Optional<Course> getCoursesRepository(Long id);
}
