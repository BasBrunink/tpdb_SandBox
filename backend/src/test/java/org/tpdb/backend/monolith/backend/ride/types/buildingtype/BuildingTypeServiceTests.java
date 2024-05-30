package org.tpdb.backend.monolith.backend.ride.types.buildingtype;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.tpdb.backend.monolith.backend.ride.types.buildingtype.dto.BuildingTypeCreateDto;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BuildingTypeServiceTests {


  @InjectMocks
  private BuildingTypeService buildingTypeService;


  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  @DisplayName("Test convertCreateDtoToBuildingType")
  void testConvertCreateDtoToBuildingType() {
    // Arrange
    BuildingTypeCreateDto dto = new BuildingTypeCreateDto("name", "description");

    // Act
    BuildingType actual = buildingTypeService.convertCreateDtoToBuildingType(dto);

    // Assert
    assertEquals("name", actual.getName());
    assertEquals("description", actual.getDescription());
  }
}

