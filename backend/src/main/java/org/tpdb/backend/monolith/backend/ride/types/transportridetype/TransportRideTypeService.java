package org.tpdb.backend.monolith.backend.ride.types.transportridetype;

import org.springframework.stereotype.Service;

import org.tpdb.backend.monolith.backend.ride.types.transportridetype.dto.TransportRideTypeCreateDto;


import java.util.List;

@Service
public class TransportRideTypeService {

  private final TransportRideTypeRepository transportRideTypeRepository;

  public TransportRideTypeService(TransportRideTypeRepository transportRideTypeRepository) {
    this.transportRideTypeRepository = transportRideTypeRepository;
  }


  public List<TransportRideType> insertManyTransportRideTypes(List<TransportRideType> types) {
    return transportRideTypeRepository.saveAll(types);
  }

  public TransportRideType convertCreateDtoToTransportRideType(TransportRideTypeCreateDto dto) {
    return TransportRideType.builder()
            .name(dto.getName())
            .description(dto.getDescription())
            .build();
  }

}
