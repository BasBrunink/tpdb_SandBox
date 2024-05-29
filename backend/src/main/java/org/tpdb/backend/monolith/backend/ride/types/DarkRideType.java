package org.tpdb.backend.monolith.backend.ride.types;

public enum DarkRideType {

  FILM("3D Film"),
  BOATRIDE("Boatride"),
  CARRIDE("Car Ride"),
  ENDLESSTRAIN("Endless Train"),
  TRAIN_RIDES("Train Rides"),
  TRACKLESS("Trackless"),
  INTERACTIVE("Interactive");



  private final String fullName;

  DarkRideType(String fullName) {
    this.fullName = fullName;
  }
}
