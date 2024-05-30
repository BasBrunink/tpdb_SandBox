package org.tpdb.backend.monolith.backend.ride.types.trackedridetype;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.tpdb.backend.monolith.backend.ride.types.trackedridetype.dto.TrackedRideCreateDto;

import static org.junit.jupiter.api.Assertions.*;

class TrackedRideTypServiceTests {

  @InjectMocks
  private TrackedRideTypeService trackedRideTypeService;

  @BeforeEach
   void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  @DisplayName("Should convert create dto to tracked ride type successfully")
  void convertCreateDtoToTrackedRideType() {
    TrackedRideCreateDto dto = new TrackedRideCreateDto("name", "description");

    TrackedRideType expected = TrackedRideType.builder()
            .name("name")
            .description("description")
            .build();

    TrackedRideType actual = trackedRideTypeService.convertCreateDtoToEntity(dto);

    assertEquals(expected.getName(), actual.getName());
    assertEquals(expected.getDescription(), actual.getDescription());
  }

}
