package org.tpdb.backend.monolith.backend.ride.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@DiscriminatorValue("TrackedRide")
public class TrackedRide extends Ride{
  private int length;
  private int height;
  private int numDrops;
}
