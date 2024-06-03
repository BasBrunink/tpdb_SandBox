package org.tpdb.backend.monolith.backend.ride.types.darkridetype;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.tpdb.backend.monolith.backend.ride.types.darkridetype.dto.DarkRideTypeCreateDto;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DarkRideTypeServiceTests {

  @InjectMocks
  private DarkRideTypeService darkRideTypeService;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  @DisplayName("Test convertCreateDtoToDarkRideType")
  void testConvertCreateDtoToDarkRideType() {
    // Arrange
    DarkRideTypeCreateDto dto = new DarkRideTypeCreateDto("name", "description");

    // Act
    DarkRideType actual = darkRideTypeService.convertCreateDtoToDarkRideType(dto);

    // Assert
    assertEquals("name", actual.getName());
    assertEquals("description", actual.getDescription());
  }
}

