package org.tpdb.backend.monolith.backend.ride.types;

import com.fasterxml.jackson.databind.KeyDeserializer;

public enum RestraintType {
  LAP_BAR("Lap Bar"),
  NONE("None");

  RestraintType(String fullName) {
    this.fullName = fullName;
  }

  private final String fullName;
}
