package org.tpdb.backend.monolith.backend.ride.types.flatRideType;

import jakarta.persistence.Entity;
import lombok.*;
import org.tpdb.backend.monolith.backend.common.models.BaseModel;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class FlatRideType extends BaseModel {
  private String name;
  private String description;
  private String thrillFactor;
  private String nauseaFactor;



}
