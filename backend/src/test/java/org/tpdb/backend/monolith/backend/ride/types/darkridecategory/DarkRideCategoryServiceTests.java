package org.tpdb.backend.monolith.backend.ride.types.darkridecategory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.tpdb.backend.monolith.backend.ride.types.darkridecategory.dto.DarkRideCategoryCreateDto;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DarkRideCategoryServiceTests {

  @Mock
  private DarkRideCategoryRepository darkRideCategoryRepository;
  @InjectMocks
  private DarkRideCategoryService darkRideCategoryService;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  @DisplayName("Test convertCreateDtoToDarkRideCategory")
  void testConvertCreateDtoToDarkRideCategory() {

    DarkRideCategoryCreateDto dto = new DarkRideCategoryCreateDto("name", "description");


    DarkRideCategory actual = darkRideCategoryService.convertCreateDtoToDarkRideCategory(dto);


    assertEquals("name", actual.getName());
    assertEquals("description", actual.getDescription());
  }
}
