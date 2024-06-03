package org.tpdb.backend.monolith.backend.ride.types.transportridetype;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TransportRideTypeRepository extends JpaRepository<TransportRideType, UUID>{
}
