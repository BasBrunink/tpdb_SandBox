package org.tpdb.backend.monolith.backend.ride.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.*;
import org.tpdb.backend.monolith.backend.ride.types.trackedridetype.TrackedRideType;
import org.tpdb.backend.monolith.backend.ride.models.attributes.vehicle.Vehicle;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@DiscriminatorValue("TrackedRide")
public class TrackedRide extends Ride{
  @OneToOne
  private TrackedRideType trackedRideType;
  @OneToOne
  Vehicle vehicle;
  private int length;


}
