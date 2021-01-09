package com.example.demo.coursers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/courses")
class CourseController {

    private final CourseService courseService;

    private CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    ResponseEntity<Void> addCourse(@RequestBody CourseDTO courseDTO) {
        return courseService.addCourse(courseDTO) ? new ResponseEntity<Void>(HttpStatus.OK) : new ResponseEntity<Void>(HttpStatus.CONFLICT);
    }

    @GetMapping
    private List<CourseDTO> getCourses() {
        return courseService.getCourses();
    }
}
