package org.tpdb.backend.monolith.backend.resort;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ResortRepository extends JpaRepository<Resort, UUID> {
}
