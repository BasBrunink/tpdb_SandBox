package org.tpdb.backend.monolith.backend.park;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController("parks")
public class ParkController {

  private final ParkService parkService;

  public ParkController(ParkService parkService) {
    this.parkService = parkService;
  }

  @PostMapping()
  public Park createPark(Park park) {
    return parkService.createPark(park);
  }

  @GetMapping()
  public List<Park> getParks() {
    return parkService.getParks();
  }

  @GetMapping("/{parkId}")
  public Park getPark(@PathVariable UUID parkId) {
    return parkService.getPark(parkId).orElse(null);
  }
  @PutMapping("/{parkId}")
  public Park updatePark(@PathVariable UUID parkId, Park park) {
    Optional<Park> foundPark = parkService.getPark(parkId);
    if (foundPark.isEmpty()) {
      return null;
    } else {
      return parkService.updatePark(park);
    }

  }

  @DeleteMapping("/{parkId}")
  public boolean deletePark(@PathVariable UUID parkId) {
    return parkService.deletePark(parkId);
  }
}
