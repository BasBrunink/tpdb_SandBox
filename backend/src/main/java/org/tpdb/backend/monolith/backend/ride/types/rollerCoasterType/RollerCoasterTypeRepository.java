package org.tpdb.backend.monolith.backend.ride.types.rollerCoasterType;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RollerCoasterTypeRepository extends JpaRepository<RollerCoasterType, UUID>{
}
