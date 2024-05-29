package org.tpdb.backend.monolith.backend.park;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.*;
import org.tpdb.backend.monolith.backend.common.enums.OperationalStatus;
import org.tpdb.backend.monolith.backend.common.models.BaseModel;
import org.tpdb.backend.monolith.backend.company.Company;
import org.tpdb.backend.monolith.backend.ride.models.Ride;

import java.time.LocalDate;
import java.util.List;

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
  @OneToMany(mappedBy = "park")
  @JsonManagedReference

  private List<Ride> rides;
//  private List<Attraction> attractions;
//  private List<Show> shows;
//  private List<Restaurant> restaurants;
//  private List<Shop> shops;
//




}
