package org.tpdb.backend.monolith.backend.ride.types;

import jakarta.persistence.Entity;
import lombok.*;
import org.tpdb.backend.monolith.backend.common.models.BaseModel;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class WaterRideType extends BaseModel {


  private String name;
  private String description;


//  LOGFLUME("Log Flume"),
//  RAPIDS("Rapids"),
//  SHOOT_THE_CHUTE("Shoot the Chute"),
//  SPIRAL_SLIDE("Spiral Slide"),
//  WATER_SLIDE("Water Slide");

}
