package org.tpdb.backend.monolith.backend.ride.types.transportridetype;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import org.tpdb.backend.monolith.backend.ride.types.transportridetype.dto.TransportRideTypeCreateDto;

import java.util.Collections;
import java.util.List;



import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;


class TransportRideTypeServiceTest {
  @Mock
  private TransportRideTypeRepository transportRideTypeRepository;

  @InjectMocks
  private TransportRideTypeService transportRideTypeService;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  @DisplayName("Should insert many transport ride types successfully")
  void insertManyTransportRideTypes() {
    List<TransportRideType> types = Collections.singletonList(new TransportRideType());
    when(transportRideTypeRepository.saveAll(types)).thenReturn(types);

    transportRideTypeService.insertManyTransportRideTypes(types);

    verify(transportRideTypeRepository, times(1)).saveAll(types);
  }

  @Test
  @DisplayName("Should convert create dto to transport ride type successfully")
  void convertCreateDtoToTransportRideType() {
    TransportRideTypeCreateDto dto = new  TransportRideTypeCreateDto("name", "description");

    TransportRideType expected = TransportRideType.builder()
            .name("name")
            .description("description")
            .build();

    TransportRideType actual = transportRideTypeService.convertCreateDtoToTransportRideType(dto);

    assertEquals(expected.getName(), actual.getName());
    assertEquals(expected.getDescription(), actual.getDescription());
  }
}