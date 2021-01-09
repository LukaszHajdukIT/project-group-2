package com.example.demo.courses.subcategories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import javax.transaction.Transactional;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@AutoConfigureMockMvc
class SubcategoryControllerTest {

    @Autowired
    private SubcategoryController subcategoryController;

    @Autowired
    private SubcategoryRepository subcategoryRepository;

    @Test
    public void shouldAddCoursesSubcategoryToRepository() {
        //when
        subcategoryController.addSubcategory(new SubcategoryDTO("Java", "How to use test"));
        //then
        assertEquals(1, subcategoryRepository.count());
    }
}