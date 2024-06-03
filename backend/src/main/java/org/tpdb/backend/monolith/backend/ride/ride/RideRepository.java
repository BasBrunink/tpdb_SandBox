package org.tpdb.backend.monolith.backend.ride.ride;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tpdb.backend.monolith.backend.ride.models.Ride;

import java.util.List;
import java.util.UUID;

@Repository
public interface RideRepository extends JpaRepository<Ride, UUID> {
  List<Ride> findByType(String type);
}
