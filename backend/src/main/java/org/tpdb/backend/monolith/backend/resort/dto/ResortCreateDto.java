package org.tpdb.backend.monolith.backend.resort.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.tpdb.backend.monolith.backend.common.enums.OperationalStatus;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResortCreateDto {
  private String name;
  private String owner;//TODO: Set to Company when Company Entity is there
  private String operator; //TODO: Set to Company when Company Entity is there
  private LocalDate openingDate;
  private LocalDate closingDate;
  private OperationalStatus operationalStatus;

}
