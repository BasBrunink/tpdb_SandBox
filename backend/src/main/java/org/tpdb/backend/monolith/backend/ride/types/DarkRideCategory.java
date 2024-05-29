package org.tpdb.backend.monolith.backend.ride.types;

public enum DarkRideCategory {


  DARKRIDE("Dark Ride"),
  SHOW_RIDE("Show Ride"),
  SEMI_DARKRIDE("Semi Dark Ride");
  DarkRideCategory(String fullName) {
    this.fullName = fullName;
  }

  private final String fullName;
}
