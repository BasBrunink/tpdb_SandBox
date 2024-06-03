package org.tpdb.backend.monolith.backend.ride.types.waterridetype;

import org.springframework.stereotype.Service;
import org.tpdb.backend.monolith.backend.ride.types.waterridetype.dto.WaterRideTypeCreateDto;

@Service
public class WaterRideTypeService {

  public WaterRideType convertCreateDtoToEntity(WaterRideTypeCreateDto createDto) {
    WaterRideType entity = new WaterRideType();
    entity.setName(createDto.getName());
    entity.setDescription(createDto.getDescription());
    return entity;
  }
}
