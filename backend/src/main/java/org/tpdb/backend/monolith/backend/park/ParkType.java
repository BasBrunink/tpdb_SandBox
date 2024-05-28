package org.tpdb.backend.monolith.backend.park;

import lombok.Getter;

@Getter
public enum ParkType {
  AMUSEMENT_PARK("Amusement park"),
  THEME_PARK("Theme park"),
  WATER_PARK("Water park"),
  ANIMAL_PARK("Animal park / zoo"),
  ADVENTURE_PARK("Adventure Park"),
  CULTURAL_PARK("Cultural Park"),
  HISTORIC_PARK("Historic Park"),
  EDUCATION_PARK("Educational Park"),
  SPECIALITY_PARK("Speciality / brand Park"),
  INDOOR_PARK("Indoor park"),
  FEC("Family entertainment Centre"),
  MINIATURE_PARK("Miniature park");

  ParkType(String fullName) {
    this.fullName = fullName;
  }

  private final String fullName;
}
