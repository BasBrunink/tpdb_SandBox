package org.tpdb.backend.monolith.backend.ride;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rides")
public class RideController {

  private final RideService rideService;

  public RideController(RideService rideService) {
    this.rideService = rideService;
  }

  @GetMapping()
  public List<Ride> getRides() {
    return rideService.getRides();
  }
}
