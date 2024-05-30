package org.tpdb.backend.monolith.backend.ride.types.flatridetype.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class FlatRideTypeCreateDto {
  private String name;
  private String description;
}
