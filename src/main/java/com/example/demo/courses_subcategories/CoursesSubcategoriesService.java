package com.example.demo.courses_subcategories;

import org.springframework.stereotype.Component;

@Component
public class CoursesSubcategoriesService {

    private final CoursesSubcategoriesRepository coursesSubcategoriesRepository;

    public CoursesSubcategoriesService(CoursesSubcategoriesRepository coursesSubcategoriesRepository) {
        this.coursesSubcategoriesRepository = coursesSubcategoriesRepository;
    }

    public void addSubcourseCategory(CoursesSubcategoriesDTO coursesSubcategoriesDTO) {
        coursesSubcategoriesRepository.save(courseSubcategories(coursesSubcategoriesDTO));
    }

    private CoursesSubcategories courseSubcategories(CoursesSubcategoriesDTO coursesSubcategoriesDTO) {
        CoursesSubcategories courseSubcategories = new CoursesSubcategories();
        courseSubcategories.setId(coursesSubcategoriesDTO.getId());
        courseSubcategories.setName(coursesSubcategoriesDTO.getName());
        courseSubcategories.setDescription(coursesSubcategoriesDTO.getDescription());
        return courseSubcategories;
    }

}
