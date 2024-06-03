package org.tpdb.backend.monolith.backend.ride.models.attributes.elementsonrollercoaster;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;
import org.tpdb.backend.monolith.backend.common.models.BaseModel;
import org.tpdb.backend.monolith.backend.ride.models.RollerCoaster;
import org.tpdb.backend.monolith.backend.ride.models.attributes.rollercoasterelement.RollerCoasterElement;


@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ElementsOnRollerCoaster extends BaseModel {
    @ManyToOne()
    private RollerCoaster coaster;
    @ManyToOne()
    private RollerCoasterElement element;
    private int position;


}
