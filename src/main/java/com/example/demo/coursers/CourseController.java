package com.example.demo.coursers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses")
public class CourseController {

   private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public void addCourse(@RequestBody CourseDTO courseDTO){
        courseService.addCourse(courseDTO);
    }


}
