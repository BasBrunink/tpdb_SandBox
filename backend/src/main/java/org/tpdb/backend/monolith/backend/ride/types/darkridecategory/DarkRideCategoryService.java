package org.tpdb.backend.monolith.backend.ride.types.darkridecategory;

import org.springframework.stereotype.Service;
import org.tpdb.backend.monolith.backend.ride.types.darkridecategory.dto.DarkRideCategoryCreateDto;

@Service
public class DarkRideCategoryService {



  public DarkRideCategory convertCreateDtoToDarkRideCategory(DarkRideCategoryCreateDto dto) {
    return DarkRideCategory.builder()
            .name(dto.getName())
            .description(dto.getDescription())
            .build();
  }
}
