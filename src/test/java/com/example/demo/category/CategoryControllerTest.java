package com.example.demo.category;

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

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Transactional
@AutoConfigureMockMvc
class CategoryControllerTest {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private CategoryController categoryController;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldAddCoursesCategoriesToRepository(){
        //when
        categoryController.addCategory(new CategoryDTO("IT", "Kategoria IT"));

        //then
        assertEquals(1, categoryRepository.count());
    }

    @Test
    public void shouldShowAddedCategory() throws Exception {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setName("IT");
        categoryDTO.setDescription("IT Kategoria");

        String content = contentAsJson(categoryDTO);
        mockMvc.perform(
                post("/category")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content)
        )
                .andExpect(status().isOk());

        MvcResult result = mockMvc.perform(
                get("/category"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andReturn();

        List<CategoryDTO> actual = objectMapper.readValue(result.getResponse().getContentAsString(),
                new TypeReference<List<CategoryDTO>>() {});

        System.out.println("ACUTAL : " + actual);
        assertEquals(actual.get(0).getDescription(), "IT Kategoria");
        assertEquals(actual.get(0).getName(), "IT");
    }

    private String contentAsJson(CategoryDTO categoryDTO) throws JsonProcessingException {
        return objectMapper.writeValueAsString(categoryDTO);
    }

//    @Test
//    public void shouldNotAddCategoryWithAlreadyExistingName() throws Exception {
//        //given
//        CategoryDTO categoryDTO = new CategoryDTO();
//        categoryDTO.setName("IT");
//        categoryDTO.setDescription("IT Kategoria");
//
//        //when
//        String content = contentAsJson(categoryDTO);
//        mockMvc.perform(
//                post("/category")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(content)
//        )
//                .andExpect(status().isOk()
//                );
//
//        mockMvc.perform(
//                post("/courses")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(content)
//        )
//                .andExpect(status().isConflict()
//                );
//
////        List<Category> courseByName = categoryRepository.findCourseByName("IT");
//
//        //then
////        assertThat(courseByName.size()).isEqualTo(1);
//    }
}