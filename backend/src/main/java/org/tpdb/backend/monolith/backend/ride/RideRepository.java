package org.tpdb.backend.monolith.backend.ride;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tpdb.backend.monolith.backend.ride.Ride;

import java.util.UUID;

public interface RideRepository extends JpaRepository<Ride, UUID> {
}
