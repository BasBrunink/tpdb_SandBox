package org.tpdb.backend.monolith.backend.ride.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;
import org.tpdb.backend.monolith.backend.company.Company;
import org.tpdb.backend.monolith.backend.ride.types.DarkRideCategory;
import org.tpdb.backend.monolith.backend.ride.types.DarkRideType;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@DiscriminatorValue("DarkRide")
public class DarkRide extends Ride{
  private int length;
  private String theme;
  private DarkRideCategory darkRideCategory;
  private DarkRideType darkRideType;
  private Company manufacturer;

}
