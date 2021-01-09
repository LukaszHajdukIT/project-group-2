package com.example.demo.courses_subcategories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@AutoConfigureMockMvc
class CoursesSubcategoriesControllerTest {

    @Autowired
    private CoursesSubcategoriesController coursesSubcategoriesController;

    @Autowired
    private CoursesSubcategoriesRepository coursesSubcategoriesRepository;

    @Test
    public void shouldAddCoursesSubcategoriesToRepository() {
        //when
        coursesSubcategoriesController.addCourseSubcategory(new CoursesSubcategoriesDTO("Java", "How to use test"));
        //then
        assertEquals(1, coursesSubcategoriesRepository.count());
        assertNotNull(coursesSubcategoriesRepository);
    }

}