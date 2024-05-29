package org.tpdb.backend.monolith.backend.ride.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.tpdb.backend.monolith.backend.common.enums.OperationalStatus;
import org.tpdb.backend.monolith.backend.common.models.BaseModel;
import org.tpdb.backend.monolith.backend.company.Company;
import org.tpdb.backend.monolith.backend.park.Park;
import org.tpdb.backend.monolith.backend.ride.types.BuildingType;
import org.tpdb.backend.monolith.backend.ride.types.LuggageHandling;
import org.tpdb.backend.monolith.backend.ride.types.RideType;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type")

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = TrackedRide.class, name = "TrackedRide"),
        @JsonSubTypes.Type(value = FlatRide.class, name = "FlatRide"),
        @JsonSubTypes.Type(value = DarkRide.class, name = "DarkRide"),
        @JsonSubTypes.Type(value = WaterRide.class, name = "WaterRide"),
//        @JsonSubTypes.Type(value = RollerCoaster.class, name = "RollerCoaster")


})

public abstract class Ride extends BaseModel {
    @ManyToOne
    @JsonBackReference
    Park park;
    private String name;
    @Column(name = "type", insertable = false, updatable = false)
    private String type;
    private String description;
    @OneToOne
    private Company manufacturer;
    @OneToOne
    private Company design;
    private RideType rideType;
    private LocalDate openingDate;
    private LocalDate closingDate;
    private OperationalStatus operationalStatus;
    private int funFactor;
    private int thrillFactor;
    private int nauseaFactor;
    private int thematization;

    private int capacity;
    private int duration;
    private int minAgeSolo;
    private int minHeightSolo;
    private int minAge;
    private int minHeight;

    private boolean FastPass;
    private boolean SingleRider;
    private boolean VirtualQueue;
    private boolean preShow;
    private boolean onRidePhoto;
    private boolean onRideVideo;
    private boolean testSeats;
    private BuildingType buildingType;
    private boolean virtualReality;
    private boolean babySwitch;
    private LuggageHandling luggageHandling;
}
