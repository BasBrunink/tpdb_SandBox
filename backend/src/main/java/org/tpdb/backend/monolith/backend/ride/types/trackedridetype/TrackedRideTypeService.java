package org.tpdb.backend.monolith.backend.ride.types.trackedridetype;


import org.springframework.stereotype.Service;
import org.tpdb.backend.monolith.backend.ride.types.trackedridetype.dto.TrackedRideCreateDto;

@Service
public class TrackedRideTypeService {

  public TrackedRideType convertCreateDtoToEntity(TrackedRideCreateDto createDto) {
    TrackedRideType entity = new TrackedRideType();
    entity.setName(createDto.getName());
    entity.setDescription(createDto.getDescription());
    return entity;
  }
}
