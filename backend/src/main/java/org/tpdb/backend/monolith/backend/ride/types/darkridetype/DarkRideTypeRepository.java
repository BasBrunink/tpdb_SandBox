package org.tpdb.backend.monolith.backend.ride.types.darkridetype;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DarkRideTypeRepository extends JpaRepository<DarkRideType, UUID> {
}
