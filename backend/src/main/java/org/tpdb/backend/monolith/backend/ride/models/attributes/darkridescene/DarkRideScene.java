package org.tpdb.backend.monolith.backend.ride.models.attributes.darkridescene;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;
import org.tpdb.backend.monolith.backend.common.models.BaseModel;
import org.tpdb.backend.monolith.backend.ride.models.DarkRide;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class DarkRideScene extends BaseModel {
  @ManyToOne
  private DarkRide darkRide;
  private String name;
  private String description;
  private int index;
}

