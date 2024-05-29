package org.tpdb.backend.monolith.backend.resort;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.tpdb.backend.monolith.backend.resort.dto.ResortCreateDto;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

class ResortServiceTests {

  @Mock
  private ResortRepository resortRepository;

  @InjectMocks
  private ResortService resortService;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }
  @Test
  @DisplayName("Should create resort successfully")
  void createResort() {
    ResortCreateDto resortDto = new ResortCreateDto();
    Resort resort = new Resort();
    when(resortRepository.save(any(Resort.class))).thenReturn(resort);
    Resort result = resortService.createResort(resortDto);
    assertEquals(resort, result);
  }

  @Test
  @DisplayName("Should get all resorts successfully")
  void getResorts() {
    when(resortRepository.findAll()).thenReturn(Collections.singletonList(new Resort()));
    List<Resort> result = resortService.getResorts();
    assertEquals(1, result.size());
  }

  @Test
  @DisplayName("Should get resort by id successfully")
  void getResort() {
    UUID resortId = UUID.randomUUID();
    when(resortRepository.findById(resortId)).thenReturn(Optional.of(new Resort()));
    Optional<Resort> result = resortService.getResort(resortId);
    assertTrue(result.isPresent());
  }

  @Test
  @DisplayName("Should Return empty when resoirt id does not exist")
  void getResortWhenResortIdDoesNotExist() {
    UUID resortId = UUID.randomUUID();
    when(resortRepository.findById(resortId)).thenReturn(Optional.empty());
    Optional<Resort> result = resortService.getResort(resortId);
    assertTrue(result.isEmpty());
  }

  @Test
  @DisplayName("Should update resort successfully")
  void updateResort() {
    Resort resort = new Resort();
    when(resortRepository.save(resort)).thenReturn(resort);
    Resort result = resortService.updateResort(resort);
    assertEquals(resort, result);
  }

  @Test
  @DisplayName("Should delete resort successfully")
  void deleteResort() {
    UUID resortId = UUID.randomUUID();
    doNothing().when(resortRepository).deleteById(resortId);
    boolean result = resortService.deleteResort(resortId);
    assertTrue(result);
  }
}
