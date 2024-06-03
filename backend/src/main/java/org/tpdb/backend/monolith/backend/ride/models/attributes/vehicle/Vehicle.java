package org.tpdb.backend.monolith.backend.ride.models.attributes.vehicle;

import jakarta.persistence.Entity;
import lombok.*;
import org.tpdb.backend.monolith.backend.common.models.BaseModel;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Vehicle extends BaseModel {
  private String name;
  private String description;
}
