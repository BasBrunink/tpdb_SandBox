package org.tpdb.backend.monolith.backend.ride.types.waterridetype;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;



import org.tpdb.backend.monolith.backend.ride.types.waterridetype.dto.WaterRideTypeCreateDto;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WaterRideTypeServiceTests {


  @InjectMocks
  private WaterRideTypeService waterRideTypeService;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  @DisplayName("Should convert create dto to transport ride type successfully")
  void convertCreateDtoToType() {
    WaterRideTypeCreateDto dto = new WaterRideTypeCreateDto("name", "description");

    WaterRideType expected = WaterRideType.builder()
        .name("name")
        .description("description")
        .build();

    WaterRideType actual = waterRideTypeService.convertCreateDtoToEntity(dto);

    assertEquals(expected.getName(), actual.getName());
    assertEquals(expected.getDescription(), actual.getDescription());
  }

}
