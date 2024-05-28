package org.tpdb.backend.monolith.backend.common.enums;

import lombok.Getter;

@Getter
public enum OperationalStatus {
  OPENED("Opened"),
  CLOSED("Closed"),
  TEMPORARILY_CLOSED("Temporarily closed"),
  SBNO("Standing but not operating"),
  REFURBISHMENT("Under refurbishment"),
  CONSTRUCTION("Under construction"),
  DEMOLISHED("Demolished"),
  CANCELLED("Cancelled"),

  UNKNOWN("Unknown");



  OperationalStatus(String fullName) {
    this.fullName = fullName;
  }

  private final String fullName;
}
