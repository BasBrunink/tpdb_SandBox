package org.tpdb.backend.monolith.backend.ride.types;

public enum RideType {

  ROLLERCOASTER("Rollercoaster"),
  DarkRide("Dark Ride"),
  FlatRide("Flat Ride");


  RideType(String fullName) {
    this.fullName = fullName;
  }

  private final String fullName;
}
