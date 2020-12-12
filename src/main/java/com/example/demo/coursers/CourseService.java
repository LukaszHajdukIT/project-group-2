package com.example.demo.coursers;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class CourseService {

   private final CoursesRepository coursesRepository;

    public CourseService(CoursesRepository coursesRepository) {
        this.coursesRepository = coursesRepository;
    }

    public void addCourse(CourseDTO courseDTO) {
        coursesRepository.save(course(courseDTO));
    }

    private Course course(CourseDTO courseDTO){
        Course course = new Course();
        course.setId(courseDTO.getId());
        course.setName(courseDTO.getName());
        course.setDescription(courseDTO.getDescription());
        course.setDuration(courseDTO.getDuration());
        return course;
    }
}
