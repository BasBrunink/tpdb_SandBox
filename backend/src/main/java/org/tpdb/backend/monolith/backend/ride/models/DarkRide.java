package org.tpdb.backend.monolith.backend.ride.models;

import jakarta.persistence.*;
import lombok.*;
import org.tpdb.backend.monolith.backend.company.Company;
import org.tpdb.backend.monolith.backend.ride.models.attributes.DarkRideScene;
import org.tpdb.backend.monolith.backend.ride.types.darkridecategory.DarkRideCategory;
import org.tpdb.backend.monolith.backend.ride.types.darkridetype.DarkRideType;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@DiscriminatorValue("DarkRide")
public class DarkRide extends Ride {
  private int length;
  private String story;
  @OneToOne
  private DarkRideCategory darkRideCategory;
  @OneToOne
  private DarkRideType darkRideType;
  @OneToMany(mappedBy = "darkRide")
  private List<DarkRideScene> scenes;

  @ManyToOne
  private Company rideSystemManufacturer;
  @ManyToOne
  private Company themingManufacturer;
  @ManyToOne
  private Company animatronicsManufacturer;
  @ManyToOne
  private Company specialEffectsManufacturer;
  @ManyToOne
  private Company audioManufacturer;
  @ManyToOne
  private Company lightingManufacturer;
  @ManyToOne
  private Company mediaManufacturer;
  @ManyToOne
  private Company showControlManufacturer;


}
