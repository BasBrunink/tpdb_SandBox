package org.tpdb.backend.monolith.backend.ride.types.darkridetype;


import org.springframework.stereotype.Service;
import org.tpdb.backend.monolith.backend.ride.types.darkridetype.dto.DarkRideTypeCreateDto;

@Service
public class DarkRideTypeService {

  DarkRideType convertCreateDtoToDarkRideType(DarkRideTypeCreateDto dto) {
    return DarkRideType.builder()
            .name(dto.getName())
            .description(dto.getDescription())
            .build();
  }
}
