package org.tpdb.backend.monolith.backend.ride.types.trackedridetype.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TrackedRideCreateDto {
  private String name;
  private String description;
}
