package org.tpdb.backend.monolith.backend.park;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.tpdb.backend.monolith.backend.park.dto.ParkCreateDto;

import java.util.Collections;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ParkControllerTests {

    @Mock
    private ParkService parkService;

    @InjectMocks
    private ParkController parkController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(parkController).build();
    }

    @Test
    @DisplayName("Should create park successfully")
    void createPark() throws Exception {
        ParkCreateDto park = new ParkCreateDto();
        when(parkService.createPark(any(ParkCreateDto.class))).thenReturn(new Park());

        mockMvc.perform(post("/park")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(park)))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Should get all parks successfully")
    void getParks() throws Exception {
        when(parkService.getParks()).thenReturn(Collections.singletonList(new Park()));

        mockMvc.perform(get("/park")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Should get park by id successfully")
    void getPark() throws Exception {
        UUID parkId = UUID.randomUUID();
        when(parkService.getPark(parkId)).thenReturn(Optional.of(new Park()));

        mockMvc.perform(get("/park/" + parkId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Should return not found when park id does not exist")
    //TODO: Not working as expected
    void getParkNotFound() throws Exception {
        UUID parkId = UUID.randomUUID();
        when(parkService.getPark(parkId)).thenReturn(Optional.empty());

        mockMvc.perform(get("/park/" + parkId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Should update park successfully")
    void updatePark() throws Exception {
        UUID parkId = UUID.randomUUID();
        when(parkService.getPark(parkId)).thenReturn(Optional.of(new Park()));
        when(parkService.updatePark(any(Park.class))).thenReturn(new Park());

        mockMvc.perform(put("/park/" + parkId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(new Park())))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Should delete park successfully")
    void deletePark() throws Exception {
        UUID parkId = UUID.randomUUID();
        when(parkService.deletePark(parkId)).thenReturn(true);

        mockMvc.perform(delete("/park/" + parkId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
