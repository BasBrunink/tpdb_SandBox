package org.tpdb.backend.monolith.backend.ride.models;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.tpdb.backend.monolith.backend.common.models.BaseModel;


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
