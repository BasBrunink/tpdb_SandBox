package org.tpdb.backend.monolith.backend.ride.types.flatridetype;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.tpdb.backend.monolith.backend.park.dto.ParkCreateDto;
import org.tpdb.backend.monolith.backend.ride.types.flatridetype.dto.FlatRideTypeCreateDto;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class FlatRideTypeServiceTests {

  @Mock
  private FlatRideTypeRepository flatRideTypeRepository;

  @InjectMocks
  private FlatRideTypeService flatRideTypeService;

  @BeforeEach
  void setup() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  @DisplayName("Should insert many flat ride types successfully")
  void insertManyFlatRideTypes() {
    List<FlatRideType> types = Collections.singletonList(new FlatRideType());
    when(flatRideTypeRepository.saveAll(types)).thenReturn(types);

    flatRideTypeService.insertManyFlatRideTypes(types);

    verify(flatRideTypeRepository, times(1)).saveAll(types);
  }

  @Test
  @DisplayName("Should convert create dto to flat ride type successfully")
  void convertCreateDtoToFlatRideType() {
    FlatRideTypeCreateDto dto = new FlatRideTypeCreateDto("name", "description");
    FlatRideType expected = FlatRideType.builder()
            .name(dto.getName())
            .description(dto.getDescription())
            .build();

    FlatRideType actual = flatRideTypeService.convertCreateDtoToFlatRideType(dto);

    assertEquals(expected.getName(), actual.getName());
    assertEquals(expected.getDescription(), actual.getDescription());
  }
}
