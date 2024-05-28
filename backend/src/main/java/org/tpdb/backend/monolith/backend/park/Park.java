package org.tpdb.backend.monolith.backend.park;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;
import org.tpdb.backend.monolith.backend.common.enums.OperationalStatus;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Park {
  @Id
  @GeneratedValue
  private UUID id;
  private String name;
  private ParkType parkType;
  //TODO: Set to Company when Company Entity is there
  private String company;
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
