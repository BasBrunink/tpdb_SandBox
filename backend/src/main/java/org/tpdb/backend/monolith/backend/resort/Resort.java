package org.tpdb.backend.monolith.backend.resort;

import jakarta.persistence.Entity;
import lombok.*;
import org.tpdb.backend.monolith.backend.common.enums.OperationalStatus;
import org.tpdb.backend.monolith.backend.common.models.BaseModel;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Resort extends BaseModel {
  private String name;
  private String operator; //TODO: Set to Company when Company Entity is there
  private String owner; //TODO: Set to Company when Company Entity is there
  private LocalDate openingDate;
  private LocalDate closingDate;
  private OperationalStatus operationalStatus;
  //todo: Set Relations See Issue #12
  //private List<Park> parks;

//  private List<Accomodation> accomodations;
//  private List<Restaurant> restaurants;
//  private List<Shop> shops;
//  private List<Show> shows;
//  private List<Attraction> attractions;
//
}
