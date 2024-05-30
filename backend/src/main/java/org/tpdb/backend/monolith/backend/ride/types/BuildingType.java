package org.tpdb.backend.monolith.backend.ride.types;

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
public class BuildingType extends BaseModel {
    private String name;
    private String description;

//    INDOOR("Indoor"),
//    OUTDOOR("Outdoor"),
//    PARTIALLY_COVERED("Partially Covered"),
//    UNKNOWN("Unknown");

}
