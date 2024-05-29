package org.tpdb.backend.monolith.backend.park;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.tpdb.backend.monolith.backend.park.dto.ParkCreateDto;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ParkServiceTests {
    @Mock
    private ParkRepository parkRepository;

    @InjectMocks
    private ParkService parkService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Should create park successfully")
    void createPark() {
        ParkCreateDto parkDto = new ParkCreateDto();
        Park park = new Park();
        when(parkRepository.save(any(Park.class))).thenReturn(park);

        Park result = parkService.createPark(parkDto);

        assertEquals(park, result);
    }

    @Test
    @DisplayName("Should get all parks successfully")
    void getParks() {
        when(parkRepository.findAll()).thenReturn(Collections.singletonList(new Park()));

        List<Park> result = parkService.getParks();

        assertEquals(1, result.size());
    }

    @Test
    @DisplayName("Should get park by id successfully")
    void getPark() {
        UUID parkId = UUID.randomUUID();
        when(parkRepository.findById(parkId)).thenReturn(Optional.of(new Park()));

        Optional<Park> result = parkService.getPark(parkId);

        assertTrue(result.isPresent());
    }

    @Test
    @DisplayName("Should return empty when park id does not exist")
    void getParkNotFound() {
        UUID parkId = UUID.randomUUID();
        when(parkRepository.findById(parkId)).thenReturn(Optional.empty());

        Optional<Park> result = parkService.getPark(parkId);

        assertFalse(result.isPresent());
    }

    @Test
    @DisplayName("Should update park successfully")
    void updatePark() {
        Park park = new Park();
        when(parkRepository.save(any(Park.class))).thenReturn(park);

        Park result = parkService.updatePark(park);

        assertEquals(park, result);
    }

    @Test
    @DisplayName("Should delete park successfully")
    void deletePark() {
        UUID parkId = UUID.randomUUID();
        doNothing().when(parkRepository).deleteById(parkId);

        boolean result = parkService.deletePark(parkId);

        assertTrue(result);
    }

    @Test
    @DisplayName("Should return false when delete fails")
    void deleteParkFailure() {
        UUID parkId = UUID.randomUUID();
        doThrow(new RuntimeException()).when(parkRepository).deleteById(parkId);

        boolean result = parkService.deletePark(parkId);

        assertFalse(result);
    }
}
