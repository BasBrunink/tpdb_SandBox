package org.tpdb.backend.monolith.backend.ride.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.*;
import org.tpdb.backend.monolith.backend.ride.models.attributes.vehicle.Vehicle;
import org.tpdb.backend.monolith.backend.ride.types.waterridetype.WaterRideType;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@DiscriminatorValue("WaterRide")
public class WaterRide extends Ride{
  @OneToOne
  private WaterRideType waterRideType;
  @OneToOne
  private Vehicle vehicle;

}
