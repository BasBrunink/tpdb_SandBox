package org.tpdb.backend.monolith.backend.ride.darkride;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tpdb.backend.monolith.backend.ride.models.DarkRide;

import java.util.UUID;

public interface DarkRideRepository extends JpaRepository<DarkRide, UUID> {
}
