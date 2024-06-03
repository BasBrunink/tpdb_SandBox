package org.tpdb.backend.monolith.backend.ride.models.attributes.darkridescene.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DarkRideSceneCreateDto {
  private UUID darkRideId;
  private String name;
  private String description;
  private int index;
}
