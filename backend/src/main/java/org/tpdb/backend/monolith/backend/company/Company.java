package org.tpdb.backend.monolith.backend.company;


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
public class Company extends BaseModel {
private String name;
private String description;
private String website;
private String email;
private CompanyType companyType;
private LocalDate foundingDate;
private LocalDate closingDate;
private OperationalStatus operationalStatus;


}
