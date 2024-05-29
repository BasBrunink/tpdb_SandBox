package org.tpdb.backend.monolith.backend.ride;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tpdb.backend.monolith.backend.ride.models.Ride;

import java.util.List;

@RestController
@RequestMapping("/rides")
public class RideController {

  private final RideService rideService;

  public RideController(RideService rideService) {
    this.rideService = rideService;
  }


  //TODO: Create POSTS for different types of rides

  @GetMapping()
  public List<Ride> getRides() {
    return rideService.getRides();
  }

  @GetMapping("/type/{type}")
  public List<Ride> getRollerCoasters(@PathVariable String type) {
    return rideService.getRidesByType(type);
  }
}
