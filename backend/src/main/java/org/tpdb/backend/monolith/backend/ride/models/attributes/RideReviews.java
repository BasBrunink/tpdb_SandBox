package org.tpdb.backend.monolith.backend.ride.models.attributes;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.*;
import org.tpdb.backend.monolith.backend.common.models.BaseModel;
import org.tpdb.backend.monolith.backend.ride.models.Ride;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RideReviews extends BaseModel {
  @ManyToOne
  private Ride ride;
  private int funFactor;
  private int thrillFactor;
  private int nauseaFactor;
  private int thematization;
  private int notes;
}
