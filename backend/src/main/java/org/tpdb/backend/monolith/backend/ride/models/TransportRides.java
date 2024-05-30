package org.tpdb.backend.monolith.backend.ride.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.*;
import org.tpdb.backend.monolith.backend.ride.models.attributes.Vehicle;
import org.tpdb.backend.monolith.backend.ride.types.transportridetype.TransportRideType;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@DiscriminatorValue("TransportRides")
public class TransportRides extends Ride{
  @OneToOne
  private TransportRideType transportRideType;
  @OneToOne
  Vehicle vehicle;
}
