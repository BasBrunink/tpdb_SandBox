package org.tpdb.backend.monolith.backend.ride;

import org.springframework.stereotype.Service;
import org.tpdb.backend.monolith.backend.ride.models.DarkRide;
import org.tpdb.backend.monolith.backend.ride.models.Ride;
import org.tpdb.backend.monolith.backend.ride.models.TrackedRide;

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
  public Ride updateRide(Ride ride) {
    return rideRepository.save(ride);
  }
  public DarkRide createDarkRide(DarkRide darkRide) {
    return rideRepository.save(darkRide);
  }
  public TrackedRide createRollerCoaster(TrackedRide rollerCoaster) {
    return rideRepository.save(rollerCoaster);
  }

  public List<Ride> getRides() {
    return rideRepository.findAll();
  }

  public List<Ride> getRidesByType(String type) {
    return rideRepository.findByType(type);
  }

  public void insertManyFlatRideTypes(List<Ride> types) {
    rideRepository.saveAll(types);
  }
}
