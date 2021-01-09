package com.example.demo.courses_categories;

import org.springframework.stereotype.Component;

@Component
public class CoursesCategoriesService {

    private final CoursesCategoriesRepository coursesCategoriesRepository;

    public CoursesCategoriesService(CoursesCategoriesRepository coursesCategoriesRepository) {
        this.coursesCategoriesRepository = coursesCategoriesRepository;
    }

    public void addCourseCategory(CoursesCategoriesDTO coursesCategoriesDTO) {
        coursesCategoriesRepository.save(coursesCategories(coursesCategoriesDTO));
    }

    private CoursesCategories coursesCategories(CoursesCategoriesDTO coursesCategoriesDTO) {
        CoursesCategories coursesCategories = new CoursesCategories();
        coursesCategories.setId(coursesCategoriesDTO.getId());
        coursesCategories.setName(coursesCategoriesDTO.getName());
        coursesCategories.setDescription(coursesCategoriesDTO.getDescription());
        return coursesCategories;
    }
}
