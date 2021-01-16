package com.example.demo.coursers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import javax.transaction.Transactional;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Transactional
@AutoConfigureMockMvc
class CourseControllerTest {

    private final ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    private CourseController courseController;

    @Autowired
    private CoursesRepository coursesRepository;

    @Autowired
    private CourseService courseService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldAddCourseToRepository() {
        //when
        courseController.addCourse(new CourseDTO("Java", "Basics", 8));
        //then
        assertEquals(6, coursesRepository.count());
        assertNotNull(coursesRepository);
    }

    @Test
    public void shouldShowAddedCourse() throws Exception {
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setName("Java");
        courseDTO.setDescription("Basics");
        courseDTO.setDuration(2);
        String content = contentAsJson(courseDTO);
        mockMvc.perform(
                post("/courses")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content)
        )
                .andExpect(status().isOk());

        MvcResult result = mockMvc.perform(
                get("/courses"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andReturn();

        List<CourseDTO> actual = objectMapper.readValue(result.getResponse().getContentAsString(),
                new TypeReference<List<CourseDTO>>() {});

        System.out.println(actual);
        assertEquals(actual.get(0).getDescription(), "Basics");
        assertEquals(actual.get(0).getName(), "Java");
        assertEquals(actual.get(0).getDuration(), 2);
    }

    private String contentAsJson(CourseDTO courseDTO) throws JsonProcessingException {
        return objectMapper.writeValueAsString(courseDTO);
    }

    @Test
    public void shouldNotAddCourseWithAlreadyExistingName() throws Exception {
        //given
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setName("Java");
        courseDTO.setDescription("Basics");
        courseDTO.setDuration(2);

        //when
        String content = contentAsJson(courseDTO);
        mockMvc.perform(
                post("/courses")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content)
        )
                .andExpect(status().isOk()
                );

        mockMvc.perform(
                post("/courses")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content)
        )
                .andExpect(status().isConflict()
                );

        List<Course> courseByName = coursesRepository.findCourseByName("Java");

        //then
        assertThat(courseByName.size()).isEqualTo(1);
    }
}