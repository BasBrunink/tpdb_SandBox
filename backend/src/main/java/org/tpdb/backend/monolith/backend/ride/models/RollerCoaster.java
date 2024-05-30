package org.tpdb.backend.monolith.backend.ride.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.*;
import org.tpdb.backend.monolith.backend.ride.models.attributes.ElementsOnRollerCoaster;
import org.tpdb.backend.monolith.backend.ride.types.*;
import org.tpdb.backend.monolith.backend.ride.types.rollerCoasterType.RollerCoasterType;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@DiscriminatorValue("RollerCoaster")
public class RollerCoaster extends Ride {
    @OneToOne
    private RollerCoasterType rollerCoasterType;
    private int length;
    private int numberOfInversions;
    private int height;
    private int topSpeed;
    private int topGforce;
    private int numberOfTrains;
    private int numberOfCarsPerTrain;
    private int rowsPerCar;
    private int seatsPerRow;
    private int personsPerTrain;
    private boolean bigBoySeats;
    @OneToOne
    private RestraintType restraintType;
    private boolean HydraulicRestraint;
    @OneToMany(mappedBy = "coaster")
    private List<ElementsOnRollerCoaster> elementsOnRollerCoasters;





}