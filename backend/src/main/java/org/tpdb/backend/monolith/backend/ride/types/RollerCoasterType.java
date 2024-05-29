package org.tpdb.backend.monolith.backend.ride.types;

import org.aspectj.apache.bcel.classfile.Unknown;

public enum RollerCoasterType {
  WOODEN("Wooden"),
  HYBRID("Hybrid"),
  STEEL("Steel"),
  FLYING("Flying"),
  LAUNCHED("Launched"),
  PIPELINE("Pipeline"),
  SPINNING("Spinning"),
  STANDUP("Standup"),
  SUSPENDED("Suspended"),
  TILTING("Tilting"),
  WINGED("Winged"),
  UNKNOWN("Unknown");

  RollerCoasterType(String fullName) {
    this.fullName = fullName;
  }

  private final String fullName;
}
