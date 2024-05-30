package org.tpdb.backend.monolith.backend.ride.types.transportRideType;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TransportRideTypeRepository extends JpaRepository<TransportRideType, UUID>{
}
