package org.tpdb.backend.monolith.backend.park.dto;

import lombok.*;
import org.tpdb.backend.monolith.backend.common.enums.OperationalStatus;
import org.tpdb.backend.monolith.backend.park.ParkType;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ParkCreateDto {
  private String name;
  private ParkType parkType;
  private LocalDate openingDate;
  private LocalDate closingDate;
  private OperationalStatus operationalStatus;
}