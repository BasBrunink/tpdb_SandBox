package org.tpdb.backend.monolith.backend.ride.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;
import org.tpdb.backend.monolith.backend.common.enums.OperationalStatus;
import org.tpdb.backend.monolith.backend.company.Company;
import org.tpdb.backend.monolith.backend.park.Park;
import org.tpdb.backend.monolith.backend.ride.types.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@DiscriminatorValue("RollerCoaster")
public class RollerCoaster extends Ride {
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
    private RestraintType restraintType;
    private boolean HydraulicRestraint;





}
