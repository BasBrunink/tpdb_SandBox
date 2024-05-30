package org.tpdb.backend.monolith.backend.ride.types.darkridetype.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DarkRideTypeCreateDto {
  private String name;
  private String description;
}
