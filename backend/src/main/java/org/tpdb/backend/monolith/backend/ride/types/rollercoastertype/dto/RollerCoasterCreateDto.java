package org.tpdb.backend.monolith.backend.ride.types.rollercoastertype.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RollerCoasterCreateDto {
  private String name;
  private String description;
}
