package com.example.demo.coursers;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

class CourseService {

    private final CoursesRepository coursesRepository;

     CourseService(CoursesRepository coursesRepository) {
        this.coursesRepository = coursesRepository;
    }

     boolean addCourse(CourseDTO courseDTO) {
        if (nameAlreadyExists(courseDTO.getName())) {
            return false;
        } else {
            coursesRepository.save(course(courseDTO));
            return true;
        }
    }

    private boolean nameAlreadyExists(String courseName) {
        return !coursesRepository.findCourseByName(courseName).isEmpty();
    }

    List<CourseDTO> getCourses() {
        List<Course> allCourses = coursesRepository.findAll();
        List<CourseDTO> allCoursesDTO = new ArrayList<>();

        for (Course course : allCourses) {
            CourseDTO courseDTO = courseDTO(course);
            allCoursesDTO.add(courseDTO);
        }
        return allCoursesDTO;
    }

    private Course course(CourseDTO courseDTO) {
        Course course = new Course();
        course.setId(courseDTO.getId());
        course.setName(courseDTO.getName());
        course.setDescription(courseDTO.getDescription());
        course.setDuration(courseDTO.getDuration());
        return course;
    }

    private CourseDTO courseDTO(Course course) {
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setId(course.getId());
        courseDTO.setName(course.getName());
        courseDTO.setDescription(course.getDescription());
        courseDTO.setDuration(course.getDuration());
        return courseDTO;
    }
}
