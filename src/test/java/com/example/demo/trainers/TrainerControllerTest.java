package com.example.demo.trainers;

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

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class TrainerControllerTest {

    private final ObjectMapper objectMapper = new ObjectMapper();
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
        trainerController.addTrainer(new TrainerDTO("Michał", "Witek", (long) 838383));
        //then
        assertEquals(1, trainersRepository.count());
        assertNotNull(trainersRepository);
    }

    @Test
    public void shouldShowAddedTrainers() throws Exception {
        TrainerDTO trainerDTO = new TrainerDTO();
        trainerDTO.setFirstName("Ania");
        trainerDTO.setLastName("Niemiec");
        trainerDTO.setPesel(567890L);

        String content = contentAsJson(trainerDTO);

        mockMvc.perform(
                post("/trainers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content)
        )
                .andExpect(status().isOk());

        MvcResult result = mockMvc.perform(
                get("/trainers"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andReturn();

        List<TrainerDTO> actual = objectMapper.readValue(result.getResponse().getContentAsString(),
                new TypeReference<List<TrainerDTO>>() {
                });

        assertEquals(actual.get(0).getFirstName(), "Ania");
        assertEquals(actual.get(0).getLastName(), "Niemiec");
        assertEquals(actual.get(0).getPesel(), 567890L);
    }

    private String contentAsJson(TrainerDTO trainerDTO) throws JsonProcessingException {
        return objectMapper.writeValueAsString(trainerDTO);
    }

    @Test
    public void shouldNotAddTwoTrainersWithAlreadyExistingFirstAndLastName() throws Exception {
        //given
        TrainerDTO trainerDTO = new TrainerDTO();
        trainerDTO.setFirstName("Ania");
        trainerDTO.setLastName("Niemiec");
        trainerDTO.setPesel(8403240011L);
        String content = contentAsJson(trainerDTO);

        //when
        mockMvc.perform(
                post("/trainers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content)
        )
                .andExpect(status().isOk());

        mockMvc.perform(
                post("/trainers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content)
        )
                .andExpect(status().isConflict());

        List<Trainer> trainerByName = trainersRepository.findTrainerByPesel(8403240011L);

        //then
        assertThat(trainerByName.size()).isEqualTo(1);
    }
}
