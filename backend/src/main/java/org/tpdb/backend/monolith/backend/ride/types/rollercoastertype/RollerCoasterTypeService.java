package org.tpdb.backend.monolith.backend.ride.types.rollercoastertype;

import org.springframework.stereotype.Service;
import org.tpdb.backend.monolith.backend.ride.types.rollercoastertype.dto.RollerCoasterCreateDto;

import java.util.List;

@Service
public class RollerCoasterTypeService {

  private final RollerCoasterTypeRepository rollerCoasterTypeRepository;

  public RollerCoasterTypeService(RollerCoasterTypeRepository rollerCoasterTypeRepository) {
    this.rollerCoasterTypeRepository = rollerCoasterTypeRepository;
  }

  public List<RollerCoasterType> insertManyRollerCoasterTypes(List<RollerCoasterType> types) {
    return rollerCoasterTypeRepository.saveAll(types);
  }
  public RollerCoasterType convertCreateDtoToRollerCoasterType(RollerCoasterCreateDto dto) {
    return RollerCoasterType.builder()
            .name(dto.getName())
            .description(dto.getDescription())
            .build();
  }
}
