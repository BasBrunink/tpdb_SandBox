package org.tpdb.backend.monolith.backend.ride.types.buildingtype.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BuildingTypeCreateDto {
  private String name;
  private String description;
}
