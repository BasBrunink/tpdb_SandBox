package org.tpdb.backend.monolith.backend.ride.types.darkridecategory;

import jakarta.persistence.Entity;
import lombok.*;
import org.tpdb.backend.monolith.backend.common.models.BaseModel;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class DarkRideCategory extends BaseModel {
  private String name;
  private String description;




}
