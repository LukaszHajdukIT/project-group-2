package com.example.demo.courses_categories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
@AutoConfigureMockMvc
class CoursesCategoriesControllerTest {

    @Autowired
    private CoursesCategoriesController coursesCategoriesController;

    @Autowired
    private CoursesCategoriesRepository coursesCategoriesRepository;

    @Test
    public void shouldAddCoursesCategoriesToRepository(){
        //when
        coursesCategoriesController.addCourseCategory(new CoursesCategoriesDTO("IT", "Kategoria IT"));

        //then
        assertEquals(1, coursesCategoriesRepository.count());
        assertNotNull(coursesCategoriesRepository);
    }
}