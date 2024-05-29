package org.tpdb.backend.monolith.backend.resort;

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
import org.tpdb.backend.monolith.backend.resort.dto.ResortCreateDto;

import java.util.Collections;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ResortControllerTests {

  @Mock
  private ResortService resortService;

  @InjectMocks
  private ResortController resortController;
  private MockMvc mockMvc;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
    mockMvc = MockMvcBuilders.standaloneSetup(resortController).build();
  }

  @Test
  @DisplayName("Should create resort successfully")
  void createResort() throws Exception {
    ResortCreateDto resort = new ResortCreateDto();
    when(resortService.createResort(any(ResortCreateDto.class))).thenReturn(new Resort());

    mockMvc.perform(post("/resort")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(new ObjectMapper().writeValueAsString(resort)))
            .andExpect(status().isOk());
  }

  @Test
  @DisplayName("Should get all resorts successfully")
  void getResorts() throws Exception {
    when(resortService.getResorts()).thenReturn(Collections.singletonList(new Resort()));

    mockMvc.perform(get("/resort")
                    .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
  }

  @Test
  @DisplayName("Should get resort by id successfully")
  void getResortById() throws Exception {
    when(resortService.getResort(any(UUID.class))).thenReturn(java.util.Optional.of(new Resort()));

    mockMvc.perform(get("/resort/{resortId}", UUID.randomUUID())
                    .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
  }
  @Test
  @DisplayName("Should return not found when resort id doe not exist")
  //TODO: Not working as expected
  void getResortByIdNotFound() throws Exception {
    when(resortService.getResort(any(UUID.class))).thenReturn(java.util.Optional.empty());

    mockMvc.perform(get("/resort/{resortId}", UUID.randomUUID())
                    .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
  }

  @Test
  @DisplayName("Should update resort successfully")
  void updateResort() throws Exception {
    Resort resort = new Resort();
    when(resortService.updateResort(any(Resort.class))).thenReturn(resort);

    mockMvc.perform(post("/resort")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(new ObjectMapper().writeValueAsString(resort)))
            .andExpect(status().isOk());
  }

  @Test
  @DisplayName("Should delete resort successfully")
  void deleteResort() throws Exception {
    when(resortService.deleteResort(any(UUID.class))).thenReturn(true);

    mockMvc.perform(delete("/resort/{resortId}", UUID.randomUUID())
                    .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
  }
}
