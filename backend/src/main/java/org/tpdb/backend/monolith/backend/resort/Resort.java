package org.tpdb.backend.monolith.backend.resort;

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
public class Resort extends BaseModel {
  private String name;
  @OneToOne
  private Company operator;
  @OneToOne
  private Company owner;
  private LocalDate openingDate;
  private LocalDate closingDate;
  private OperationalStatus operationalStatus;
  //todo: Set Relations See Issue #12
//  private List<Park> parks;
//  private List<Accomodation> accomodations;
//  private List<Restaurant> restaurants;
//  private List<Shop> shops;
//  private List<Show> shows;
//  private List<Attraction> attractions;
//
}
