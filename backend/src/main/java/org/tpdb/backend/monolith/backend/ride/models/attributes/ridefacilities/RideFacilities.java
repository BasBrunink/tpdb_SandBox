package org.tpdb.backend.monolith.backend.ride.models.attributes.ridefacilities;

import jakarta.persistence.Entity;
import lombok.*;
import org.tpdb.backend.monolith.backend.common.models.BaseModel;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RideFacilities extends BaseModel {
  private boolean fastPass;
  private boolean singleRider;
  private boolean virtualQueue;
  private boolean onRidePhoto;
  private boolean onRideVideo;
  private boolean testSeats;
  private boolean babySwitch;
  private boolean virtualReality; //TODO: IS a Virtual reality ride as an option a ride on itself?
}
