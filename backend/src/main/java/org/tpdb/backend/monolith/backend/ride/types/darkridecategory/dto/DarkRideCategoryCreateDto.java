package org.tpdb.backend.monolith.backend.ride.types.darkridecategory.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DarkRideCategoryCreateDto {
  private String name;
  private String description;
}
