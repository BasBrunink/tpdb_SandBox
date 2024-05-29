package org.tpdb.backend.monolith.backend.ride;

import org.springframework.stereotype.Service;

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
  public DarkRide createDarkRide(DarkRide darkRide) {
    return rideRepository.save(darkRide);
  }
  public RollerCoaster createRollerCoaster(RollerCoaster rollerCoaster) {
    return rideRepository.save(rollerCoaster);
  }

  public List<Ride> getRides() {
    return rideRepository.findAll();
  }
}
