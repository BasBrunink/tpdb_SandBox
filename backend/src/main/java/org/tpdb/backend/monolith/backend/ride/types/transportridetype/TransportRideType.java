package org.tpdb.backend.monolith.backend.ride.types.transportridetype;

import jakarta.persistence.Entity;
import lombok.*;
import org.tpdb.backend.monolith.backend.common.models.BaseModel;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class TransportRideType extends BaseModel {
  private String name;
  private String description;
}
