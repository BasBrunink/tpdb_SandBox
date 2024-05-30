package org.tpdb.backend.monolith.backend.ride.models;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.*;
import org.tpdb.backend.monolith.backend.ride.types.flatridetype.FlatRideType;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@DiscriminatorValue("FlatRide")
public class FlatRide extends Ride{

  @OneToOne
  private FlatRideType flatRideType;

}
