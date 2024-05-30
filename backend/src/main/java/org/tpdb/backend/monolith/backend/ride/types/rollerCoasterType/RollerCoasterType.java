package org.tpdb.backend.monolith.backend.ride.types.rollerCoasterType;

import jakarta.persistence.Entity;
import lombok.*;
import org.aspectj.apache.bcel.classfile.Unknown;
import org.tpdb.backend.monolith.backend.common.models.BaseModel;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class RollerCoasterType extends BaseModel {
  private int placeholder;
}
