package org.tpdb.backend.monolith.backend.ride.types.buildingtype;

import org.tpdb.backend.monolith.backend.ride.types.buildingtype.dto.BuildingTypeCreateDto;

public class BuildingTypeService {



  public BuildingType convertCreateDtoToBuildingType(BuildingTypeCreateDto dto) {
    return BuildingType.builder()
            .name(dto.getName())
            .description(dto.getDescription())
            .build();
  }
}
