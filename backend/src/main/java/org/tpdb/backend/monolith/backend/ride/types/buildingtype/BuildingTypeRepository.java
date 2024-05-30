package org.tpdb.backend.monolith.backend.ride.types.buildingtype;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BuildingTypeRepository extends JpaRepository<BuildingType, UUID> {
}
