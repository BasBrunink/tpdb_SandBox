package org.tpdb.backend.monolith.backend.common.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import java.time.LocalDate;
import java.util.UUID;

@MappedSuperclass
public class BaseModel {
  @Id
  @GeneratedValue
  private UUID id;
  private LocalDate createdAt;
  private LocalDate updatedAt;
  private String createdBy;
  private String updatedBy;



}
