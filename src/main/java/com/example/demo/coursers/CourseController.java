package com.example.demo.coursers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/course")
public class CourseController {

    CourseService courseService;

    @PostMapping
    public void addCourse(@RequestBody CourseDTO courseDTO){
        courseService.addCourse(courseDTO);
    }
}
