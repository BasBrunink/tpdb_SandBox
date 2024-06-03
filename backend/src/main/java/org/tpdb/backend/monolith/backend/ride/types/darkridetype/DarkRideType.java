package org.tpdb.backend.monolith.backend.ride.types.darkridetype;


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
}
