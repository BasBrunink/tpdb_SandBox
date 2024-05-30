package org.tpdb.backend.monolith.backend.ride.types.transportridetype.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TransportRideTypeCreateDto {
  private String name;
  private String description;
}
