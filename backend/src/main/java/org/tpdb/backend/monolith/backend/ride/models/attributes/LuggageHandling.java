package org.tpdb.backend.monolith.backend.ride.models.attributes;

public enum LuggageHandling {
    LOCK_BOX("Lock Box"),
    STATION_CABINET("Station Cabinet"),
    POUCH("Pouch"),
    NONE("None");


    private final String fullName;

    LuggageHandling(String fullName) {
        this.fullName = fullName;
    }
}
