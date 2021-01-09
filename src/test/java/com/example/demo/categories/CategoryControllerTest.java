package com.example.demo.categories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
@AutoConfigureMockMvc
class CategoryControllerTest {

    @Autowired
    private CategoryController categoryController;

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void shouldAddCoursesCategoriesToRepository(){
        //when
        categoryController.addCourseCategory(new CategoryDTO("IT", "Kategoria IT"));

        //then
        assertEquals(1, categoryRepository.count());
    }
}