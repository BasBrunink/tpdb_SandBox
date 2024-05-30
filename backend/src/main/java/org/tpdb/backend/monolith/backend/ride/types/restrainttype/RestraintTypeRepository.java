package org.tpdb.backend.monolith.backend.ride.types.restrainttype;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RestraintTypeRepository extends JpaRepository<RestraintType, UUID> {
}
