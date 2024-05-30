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
public class DarkRideType extends BaseModel {

  private String name;
  private String description;





//  FILM("3D Film"),
//  BOATRIDE("Boatride"),
//  CARRIDE("Car Ride"),
//  ENDLESSTRAIN("Endless Train"),
//  TRAIN_RIDES("Train Rides"),
//  TRACKLESS("Trackless"),
//  INTERACTIVE("Interactive");




}
