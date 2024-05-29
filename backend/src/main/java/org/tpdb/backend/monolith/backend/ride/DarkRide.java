package org.tpdb.backend.monolith.backend.ride;

import jakarta.persistence.Entity;
import lombok.*;
import org.tpdb.backend.monolith.backend.ride.types.DarkRideType;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class DarkRide extends Ride{
  private int length;
  private String theme;
  private DarkRideType darkRideType;
}
