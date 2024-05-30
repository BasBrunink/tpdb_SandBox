package org.tpdb.backend.monolith.backend.ride.models.attributes;

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
}
