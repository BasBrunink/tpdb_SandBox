package org.tpdb.backend.monolith.backend.ride;

import org.springframework.stereotype.Service;
import org.tpdb.backend.monolith.backend.ride.models.DarkRide;
import org.tpdb.backend.monolith.backend.ride.models.Ride;
import org.tpdb.backend.monolith.backend.ride.models.RollerCoaster;
import org.tpdb.backend.monolith.backend.ride.models.TrackedRide;
import org.tpdb.backend.monolith.backend.ride.types.rollercoastertype.dto.RollerCoasterCreateDto;

import java.util.List;

@Service
public class RideService {


  private final RideRepository rideRepository;


  public RideService(RideRepository rideRepository) {
    this.rideRepository = rideRepository;
  }

  public Ride createRide(Ride ride) {
    return rideRepository.save(ride);
  }
  public List<Ride> getRides() {
    return rideRepository.findAll();
  }

  public List<Ride> getRidesByType(String type) {
    return rideRepository.findByType(type);
  }

}
