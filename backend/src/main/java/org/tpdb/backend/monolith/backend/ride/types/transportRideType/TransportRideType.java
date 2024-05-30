package org.tpdb.backend.monolith.backend.ride.types.transportRideType;

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
  private int placeholder;
}
