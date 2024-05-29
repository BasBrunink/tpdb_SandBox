package org.tpdb.backend.monolith.backend.company.dto;

import org.tpdb.backend.monolith.backend.common.enums.OperationalStatus;
import org.tpdb.backend.monolith.backend.company.CompanyType;

import java.time.LocalDate;

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
