package com.example.demo.coursers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CourseControllerTest {

    @Autowired
    private CourseController courseController;

    @Autowired
    private CoursesRepository coursesRepository;

    @Autowired
    private CourseService courseService;

    @Test
    public void should(){
        //when
        courseService.addCourse(new CourseDTO("Java", "Basics", 8));
        //then
        assertEquals(1, coursesRepository.count());
    }
}