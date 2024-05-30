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
public class RestraintType extends BaseModel {

  private String name;
  private String description;

}
