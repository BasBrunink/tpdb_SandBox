package org.tpdb.backend.monolith.backend.ride.darkride;

import org.springframework.stereotype.Service;
import org.tpdb.backend.monolith.backend.ride.models.DarkRide;

import java.util.Optional;
import java.util.UUID;

@Service
public class DarkRideService {

  private final DarkRideRepository darkRideRepository;

  public DarkRideService(DarkRideRepository darkRideRepository) {
    this.darkRideRepository = darkRideRepository;
  }

  public Optional<DarkRide> getById(UUID id) {
    return darkRideRepository.findById(id);
  }
}
