package com.example.demo.trainers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class TrainerControllerTest {

    @Autowired
    private TrainerController trainerController;

    @Autowired
    private TrainersRepository trainersRepository;

    @Autowired
    private TrainerService trainerService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldShowTrainers() {
        //when
        trainerService.addTrainer(new TrainerDTO("Michał", "Witek", (long) 838383));
        //then
        assertEquals(1, trainersRepository.count());
        assertNotNull(trainersRepository);
    }

    @Test
    public void test() throws Exception {
        TrainerDTO trainerDTO = new TrainerDTO();
        trainerDTO.setFirstName("Ania");
        trainerDTO.setLastName("Niemiec");
        trainerDTO.setPesel(567890L);

        String content = contentAsJson(trainerDTO);
        System.out.println(content);

        mockMvc.perform(
                post("/trainers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content)
        )
                .andExpect(status().isOk());
    }

    private String contentAsJson(TrainerDTO trainerDTO) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(trainerDTO);
    }
}
