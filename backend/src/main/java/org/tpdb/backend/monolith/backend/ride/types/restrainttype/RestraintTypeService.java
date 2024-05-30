package org.tpdb.backend.monolith.backend.ride.types.restrainttype;

import org.tpdb.backend.monolith.backend.ride.types.restrainttype.dto.RestraintTypeCreateDto;

public class RestraintTypeService {
  public RestraintType convertCreateDtoToTransportRideType(RestraintTypeCreateDto dto) {
    return RestraintType.builder()
            .name(dto.getName())
            .description(dto.getDescription())
            .build();
  }
}
