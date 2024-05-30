package org.tpdb.backend.monolith.backend.ride.models.attributes;


import jakarta.persistence.Entity;
import lombok.*;
import org.tpdb.backend.monolith.backend.common.models.BaseModel;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class RollerCoasterElement extends BaseModel {
    private String name;
    private int inversions;
    private String description;
}
