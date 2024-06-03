package org.tpdb.backend.monolith.backend.ride.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;
import lombok.*;
import org.tpdb.backend.monolith.backend.common.enums.OperationalStatus;
import org.tpdb.backend.monolith.backend.common.models.BaseModel;
import org.tpdb.backend.monolith.backend.common.models.InvolvedCompanies;
import org.tpdb.backend.monolith.backend.common.models.Location;
import org.tpdb.backend.monolith.backend.park.Park;
import org.tpdb.backend.monolith.backend.ride.models.attributes.luggagehandling.LuggageHandling;
import org.tpdb.backend.monolith.backend.ride.models.attributes.ridefacilities.RideFacilities;
import org.tpdb.backend.monolith.backend.ride.models.attributes.riderestrictions.RideRestrictions;
import org.tpdb.backend.monolith.backend.ride.models.attributes.ridereviews.RideReviews;
import org.tpdb.backend.monolith.backend.ride.types.buildingtype.BuildingType;

import java.time.LocalDate;
import java.util.List;

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
        @JsonSubTypes.Type(value = RollerCoaster.class, name = "RollerCoaster"),
        @JsonSubTypes.Type(value = TransportRides.class, name = "TransportRides")


})

public abstract class Ride extends BaseModel {
    private String name;
    @Column(name = "type", insertable = false, updatable = false)
    private String type;
    private String description;
    @ManyToOne
    @JsonBackReference
    Park park;
    @OneToOne
    Location location;
    @OneToMany(mappedBy = "ride")
    private List<RideReviews> reviews;
    @OneToOne
    private InvolvedCompanies involvedCompanies;
    @OneToOne
    private RideRestrictions restrictions;
    @OneToOne
    private RideFacilities facilities;
    private LocalDate openingDate;
    private LocalDate closingDate;
    private OperationalStatus operationalStatus;
    private LuggageHandling luggageHandling;
    @OneToOne
    private BuildingType buildingType;
    private int capacity;
    private int duration;
    private String theme;

}
