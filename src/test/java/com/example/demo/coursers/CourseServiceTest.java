package com.example.demo.coursers;

import com.example.demo.courses.subcategory.Subcategory;
import com.example.demo.courses.subcategory.SubcategoryRepository;
import com.example.demo.courses.subcategory.SubcategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class CourseServiceTest {

    @Autowired
    CourseService courseService;

    @Autowired
    SubcategoryService subcategoryService;

    @Autowired
    CoursesRepository coursesRepository;

    @Autowired
    SubcategoryRepository subcategoryRepository;

    @BeforeEach
    public void init(){
        Subcategory java = new Subcategory("Java", "description");
        Subcategory javaScript = new Subcategory("JavaScript", "description");
        subcategoryRepository.save(java);
        subcategoryRepository.save(javaScript);

        Course java2 = new Course("Java2", "description", 8, java);
        Course java3 = new Course("Java3", "description", 8, java);
        Course java4 = new Course("Java4", "description", 8, java);
        Course javaScript2 = new Course("JavaScript2", "description", 8, javaScript);
        Course javaScript3 = new Course("JavaScript3", "description", 8, javaScript);
        coursesRepository.save(java2);
        coursesRepository.save(java3);
        coursesRepository.save(java4);
        coursesRepository.save(javaScript2);
        coursesRepository.save(javaScript3);
    }

    @Test
    public void shouldReturnCoursesOnlyWithGivenSubcategory(){
        //when
        Optional<Subcategory> java = subcategoryRepository.findSubcategoryByName("Java");
        List<CourseDTO> result = courseService.getCourses(java.get().getId());
        //then
        assertThat(result.size()).isEqualTo(3);
    }
}