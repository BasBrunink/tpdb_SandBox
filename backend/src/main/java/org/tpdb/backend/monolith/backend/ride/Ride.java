package org.tpdb.backend.monolith.backend.ride;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;
import lombok.*;
import org.tpdb.backend.monolith.backend.common.models.BaseModel;
import org.tpdb.backend.monolith.backend.ride.types.RideType;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
  @JsonSubTypes.Type(value = RollerCoaster.class, name = "RollerCoaster"),
  @JsonSubTypes.Type(value = DarkRide.class, name = "DarkRide")
})
@Entity
public class Ride extends BaseModel {
  private String name;
  private String description;
  private RideType rideType;
  private int duration;
  private int minAge;
  private int minHeight;

}
