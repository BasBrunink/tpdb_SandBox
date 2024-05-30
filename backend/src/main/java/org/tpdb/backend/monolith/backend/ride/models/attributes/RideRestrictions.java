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
public class RideRestrictions  extends BaseModel {
  private int minAgeSolo;
  private int minHeightSolo;
  private int minAge;
  private int minHeight;
  //TODO: add disability restrictions
}
