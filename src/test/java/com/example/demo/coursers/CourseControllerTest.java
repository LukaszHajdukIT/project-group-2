package com.example.demo.coursers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CourseControllerTest {

    @Autowired
    private CourseController courseController;

    @Autowired
    private CoursesRepository coursesRepository;

    @Autowired
    private CourseService courseService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldAddCourseToRepository(){
        //when
        courseController.addCourse(new CourseDTO("Java", "Basics", 8));
        //then
        assertEquals(1, coursesRepository.count());
        assertNotNull(coursesRepository);
    }

    @Test
    public void test() throws Exception {
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setName("Java");
        courseDTO.setDescription("Basics");
        courseDTO.setDuration(2);
        String content = contentAsJson(courseDTO);
        System.out.println(content);
        mockMvc.perform(
                post("/courses")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content)
        )
                .andExpect(status().isOk());
    }

    private String contentAsJson(CourseDTO courseDTO) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(courseDTO);
    }


}