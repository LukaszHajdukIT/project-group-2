package com.example.demo.coursers;

import com.example.demo.courses.subcategory.Subcategory;
import com.example.demo.courses.subcategory.SubcategoryRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class CourseService {

    private final CoursesRepository coursesRepository;

    private SubcategoryRepository subcategoryRepository;

     CourseService(CoursesRepository coursesRepository, SubcategoryRepository subcategoryRepository) {
        this.coursesRepository = coursesRepository;
        this.subcategoryRepository = subcategoryRepository;
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

    List<CourseDTO> getCourses(Long subcategoryId) {
         Optional<Subcategory> id = subcategoryRepository.findById(subcategoryId);
        List<Course> allCourses = coursesRepository.findAllBySubcategory(id.get());
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
