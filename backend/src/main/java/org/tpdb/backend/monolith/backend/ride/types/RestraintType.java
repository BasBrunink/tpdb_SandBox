package org.tpdb.backend.monolith.backend.ride.types;

public enum RestraintType {
  LAP_BAR("Lap Bar");
  RestraintType(String fullName) {
    this.fullName = fullName;
  }

  private final String fullName;
}
