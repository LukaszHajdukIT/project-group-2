package com.example.demo.coursers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public ResponseEntity<Void> addCourse(@RequestBody CourseDTO courseDTO) {
        return courseService.addCourse(courseDTO) ? new ResponseEntity<Void>(HttpStatus.OK) : new ResponseEntity<Void>(HttpStatus.CONFLICT);

    }

    @GetMapping
    public List<CourseDTO> getCourses() {
        return courseService.getCourses();
    }
}
