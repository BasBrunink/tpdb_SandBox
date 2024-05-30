package org.tpdb.backend.monolith.backend.ride.types.restrainttype;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.tpdb.backend.monolith.backend.ride.types.restrainttype.dto.RestraintTypeCreateDto;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RestraintTypeServiceTests {

  @InjectMocks
  private RestraintTypeService restraintTypeService;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  @DisplayName("Should convert create dto to transport ride type successfully")
  void convertCreateDtoToRestraintType() {
    RestraintTypeCreateDto dto = new RestraintTypeCreateDto("name", "description");

    RestraintType expected = RestraintType.builder()
        .name("name")
        .description("description")
        .build();

    RestraintType actual = restraintTypeService.convertCreateDtoToTransportRideType(dto);

    assertEquals(expected.getName(), actual.getName());
    assertEquals(expected.getDescription(), actual.getDescription());
  }
}
