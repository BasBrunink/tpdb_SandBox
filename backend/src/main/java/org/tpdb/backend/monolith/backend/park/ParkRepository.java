package org.tpdb.backend.monolith.backend.park;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ParkRepository extends JpaRepository<Park, UUID> {
}
