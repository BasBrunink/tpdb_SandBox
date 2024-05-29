package org.tpdb.backend.monolith.backend.common.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@MappedSuperclass
@Setter
@Getter

public class BaseModel {
  @Id
  @GeneratedValue
  private UUID id;
  private LocalDate createdAt;
  private LocalDate updatedAt;
  private String createdBy;
  private String updatedBy;



}
