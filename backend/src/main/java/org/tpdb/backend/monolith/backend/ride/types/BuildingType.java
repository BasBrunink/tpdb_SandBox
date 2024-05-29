package org.tpdb.backend.monolith.backend.ride.types;

import org.aspectj.apache.bcel.classfile.Unknown;

public enum BuildingType {
    INDOOR("Indoor"),
    OUTDOOR("Outdoor"),
    PARTIALLY_COVERED("Partially Covered"),
    UNKNOWN("Unknown");

    private final String fullName;

    BuildingType(String fullName) {
        this.fullName = fullName;
    }
}
