package org.tpdb.backend.monolith.backend.common.models;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.*;
import org.tpdb.backend.monolith.backend.common.models.BaseModel;
import org.tpdb.backend.monolith.backend.company.Company;
import org.tpdb.backend.monolith.backend.ride.models.Ride;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class InvolvedCompanies extends BaseModel {
  @OneToOne
  private Ride ride;
  @OneToOne
  private Company design;
  @OneToOne
  private Company rideSystemManufacturer;
  @OneToOne
  private Company themingManufacturer;
  @OneToOne
  private Company animatronicsManufacturer;
  @OneToOne
  private Company specialEffectsManufacturer;
  @OneToOne
  private Company audioManufacturer;
  @OneToOne
  private Company lightingManufacturer;
  @OneToOne
  private Company mediaManufacturer;
  @OneToOne
  private Company showControlManufacturer;
}
