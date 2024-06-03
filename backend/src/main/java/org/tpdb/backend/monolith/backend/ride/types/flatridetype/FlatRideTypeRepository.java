package org.tpdb.backend.monolith.backend.ride.types.flatridetype;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FlatRideTypeRepository extends JpaRepository<FlatRideType, UUID> {
}
