package org.tpdb.backend.monolith.backend.ride.types.darkridecategory;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DarkRideCategoryRepository extends JpaRepository<DarkRideCategory, UUID> {
}
