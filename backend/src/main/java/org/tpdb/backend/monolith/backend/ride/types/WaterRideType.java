package org.tpdb.backend.monolith.backend.ride.types;

public enum WaterRideType {

  LOGFLUME("Log Flume"),
  RAPIDS("Rapids"),
  SHOOT_THE_CHUTE("Shoot the Chute"),
  SPIRAL_SLIDE("Spiral Slide"),
  WATER_SLIDE("Water Slide");

  WaterRideType(String fullName) {
    this.fullName = fullName;
  }

  private final String fullName;
}
