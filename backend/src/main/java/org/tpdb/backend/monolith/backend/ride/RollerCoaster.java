package org.tpdb.backend.monolith.backend.ride;

import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class RollerCoaster extends Ride{
  private int length;
  private int height;
  private int numInversions;
  private int maxSpeed;
  private int numDrops;
}
