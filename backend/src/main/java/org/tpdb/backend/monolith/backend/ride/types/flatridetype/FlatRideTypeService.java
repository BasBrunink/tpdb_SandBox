package org.tpdb.backend.monolith.backend.ride.types.flatridetype;

import org.springframework.stereotype.Service;
import org.tpdb.backend.monolith.backend.ride.types.flatridetype.dto.FlatRideTypeCreateDto;

import java.util.List;

@Service
public class FlatRideTypeService {
  private final FlatRideTypeRepository flatRideTypeRepository;

  public FlatRideTypeService(FlatRideTypeRepository flatRideTypeRepository) {
    this.flatRideTypeRepository = flatRideTypeRepository;
  }


  public void insertManyFlatRideTypes(List<FlatRideType> types) {
    flatRideTypeRepository.saveAll(types);
  }


  public FlatRideType convertCreateDtoToFlatRideType(FlatRideTypeCreateDto dto) {
    return FlatRideType.builder()
            .name(dto.getName())
            .description(dto.getDescription())
            .build();
  }
}
