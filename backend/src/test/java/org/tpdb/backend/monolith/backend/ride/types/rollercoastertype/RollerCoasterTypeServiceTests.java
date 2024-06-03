package org.tpdb.backend.monolith.backend.ride.types.rollercoastertype;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.tpdb.backend.monolith.backend.park.dto.ParkCreateDto;
import org.tpdb.backend.monolith.backend.ride.types.rollercoastertype.dto.RollerCoasterCreateDto;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class RollerCoasterTypeServiceTests {

  @Mock
  private RollerCoasterTypeRepository rollerCoasterTypeRepository;

  @InjectMocks
  private RollerCoasterTypeService rollerCoasterTypeService;

  @BeforeEach
  void setup() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  @DisplayName("Should insert many roller coaster types successfully")
  void insertManyRollerCoasterTypes() {
    List<RollerCoasterType> types = Collections.singletonList(new RollerCoasterType());
    when(rollerCoasterTypeRepository.saveAll(types)).thenReturn(types);

    rollerCoasterTypeService.insertManyRollerCoasterTypes(types);

    verify(rollerCoasterTypeRepository, times(1)).saveAll(types);
  }

  @Test
  @DisplayName("Should convert create dto to roller coaster type successfully")
  void convertCreateDtoToRollerCoasterType() {
    RollerCoasterCreateDto dto = new RollerCoasterCreateDto("name", "description");
    RollerCoasterType expected = RollerCoasterType.builder()
            .name(dto.getName())
            .description(dto.getDescription())
            .build();

    RollerCoasterType actual = rollerCoasterTypeService.convertCreateDtoToRollerCoasterType(dto);

    assertEquals(expected.getName(), actual.getName());
    assertEquals(expected.getDescription(), actual.getDescription());
  }
}
