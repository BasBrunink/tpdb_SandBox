package org.tpdb.backend.monolith.backend.park;


import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.*;
import org.tpdb.backend.monolith.backend.common.enums.OperationalStatus;
import org.tpdb.backend.monolith.backend.common.models.BaseModel;
import org.tpdb.backend.monolith.backend.company.Company;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Park extends BaseModel {
  private String name;
  private ParkType parkType;
  @OneToOne
  private Company operator;
  @OneToOne
  private Company owner;
  private LocalDate openingDate;
  private LocalDate closingDate;
  private OperationalStatus operationalStatus;
  //TODO: Set Relations See Issue #12
//  private List<Ride> rides;
//  private List<Attraction> attractions;
//  private List<Show> shows;
//  private List<Restaurant> restaurants;
//  private List<Shop> shops;
//




}
