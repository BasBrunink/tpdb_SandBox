package org.tpdb.backend.monolith.backend.park;

import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;
import org.tpdb.backend.monolith.backend.park.dto.ParkCreateDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController()
@RequestMapping("/park")
@Log
public class ParkController {

  private final ParkService parkService;

  public ParkController(ParkService parkService) {
    this.parkService = parkService;
  }

  @PostMapping()
  public Park createPark(@RequestBody ParkCreateDto park) {
    log.info("Creating Park: " + park.getName());
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
