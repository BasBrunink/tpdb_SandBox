package org.tpdb.backend.monolith.backend.company.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.tpdb.backend.monolith.backend.common.enums.OperationalStatus;
import org.tpdb.backend.monolith.backend.company.CompanyType;

import java.time.LocalDate;
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CompanyCreateDto {
  private String name;
  private String description;
  private String website;
  private String email;
  private CompanyType companyType;
  private LocalDate foundingDate;
  private LocalDate closingDate;
  private OperationalStatus operationalStatus;
}
