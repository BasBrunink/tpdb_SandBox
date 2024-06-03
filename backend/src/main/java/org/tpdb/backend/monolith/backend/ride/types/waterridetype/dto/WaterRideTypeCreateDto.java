package org.tpdb.backend.monolith.backend.ride.types.waterridetype.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class WaterRideTypeCreateDto {
  private String name;
  private String description;
}
