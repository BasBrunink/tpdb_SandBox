package org.tpdb.backend.monolith.backend.ride.types.waterridetype;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WaterRideTypeRepository extends JpaRepository<WaterRideType, UUID> {
}
