package com.example.demo.courses_subcategories;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/courses_subcategories")
public class CoursesSubcategoriesController {

    private final CoursesSubcategoriesService coursesSubcategoriesService;

    public CoursesSubcategoriesController(CoursesSubcategoriesService coursesSubcategoriesService) {
        this.coursesSubcategoriesService = coursesSubcategoriesService;
    }

    @PostMapping
    public void addCourseSubcategory(@RequestBody CoursesSubcategoriesDTO coursesSubcategoriesDTO) {
        coursesSubcategoriesService.addSubcourseCategory(coursesSubcategoriesDTO);
    }

}
