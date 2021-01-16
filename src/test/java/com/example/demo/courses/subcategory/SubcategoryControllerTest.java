package com.example.demo.courses.subcategory;

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
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Transactional
@AutoConfigureMockMvc
class SubcategoryControllerTest {

    ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private SubcategoryController subcategoryController;

    @Autowired
    private SubcategoryRepository subcategoryRepository;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldAddCoursesSubcategoryToRepository() {
        //when
        subcategoryController.addSubcategory(new SubcategoryDTO("Java", "How to use test"));
        //then
        assertEquals(1, subcategoryRepository.count());
    }

    @Test
    public void shouldShowAddedSubcategory() throws Exception {
        SubcategoryDTO subcategoryDTO = new SubcategoryDTO();
        subcategoryDTO.setName("Spring");
        subcategoryDTO.setDescription("All that matters");

        String content = contentAsJson(subcategoryDTO);
        mockMvc.perform(
                post("/subcategory")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content)
        )
                .andExpect(status().isOk());

        MvcResult result = mockMvc.perform(
                get("/subcategory"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andReturn();

        List<SubcategoryDTO> actual = objectMapper.readValue(result.getResponse().getContentAsString(),
                new TypeReference<List<SubcategoryDTO>>() {
                });

        System.out.println("dupa" + actual);
        assertEquals(actual.get(0).getName(), "Spring");
        assertEquals(actual.get(0).getDescription(), "All that matters");
    }

    private String contentAsJson(SubcategoryDTO subcategoryDTO) throws JsonProcessingException {
        return objectMapper.writeValueAsString(subcategoryDTO);
    }

    @Test
    public void shouldNotAddSubcategoryWithAlreadyExistingName() throws Exception {
        //given
        SubcategoryDTO subcategoryDTO = new SubcategoryDTO();
        subcategoryDTO.setName("Spring");
        subcategoryDTO.setDescription("All that matters");

        //when
        String content = contentAsJson(subcategoryDTO);
        mockMvc.perform(
                post("/subcategory")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content)
        )
                .andExpect(status().isOk()
                );

        mockMvc.perform(
                post("/subcategory")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content)
        )
                .andExpect(status().isConflict()
                );

        Optional<Subcategory> subcategoryByName = subcategoryRepository.findSubcategoryByName("Spring");

        //then
        assertThat(subcategoryByName.isPresent()).isTrue();
    }
}
