package com.example.demo.courses_categories;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/courses_categories")
public class CoursesCategoriesController {

    private final CoursesCategoriesService coursesCategoriesService;

    public CoursesCategoriesController(CoursesCategoriesService coursesCategoriesService) {
        this.coursesCategoriesService = coursesCategoriesService;
    }

    @PostMapping
    public void addCourseCategory(@RequestBody CoursesCategoriesDTO coursesCategoriesDTO){
        coursesCategoriesService.addCourseCategory(coursesCategoriesDTO);
    }
}
