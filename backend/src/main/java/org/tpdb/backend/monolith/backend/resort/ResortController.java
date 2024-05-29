package org.tpdb.backend.monolith.backend.resort;


import org.springframework.web.bind.annotation.*;
import org.tpdb.backend.monolith.backend.resort.dto.ResortCreateDto;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/resort")
public class ResortController {
  private final ResortService resortService;

  public ResortController(ResortService resortService) {
    this.resortService = resortService;
  }


  @PostMapping()
  public Resort createResort(ResortCreateDto resort) {
    return resortService.createResort(resort);
  }

  @GetMapping()
  public List<Resort> getResorts() {
    return resortService.getResorts();
  }
  @GetMapping("/{resortId}")
  public Resort getResort(@PathVariable UUID resortId) {
    return resortService.getResort(resortId).orElse(null);
  }
  @PutMapping("/{resortId}")
  public Resort updateResort(@PathVariable UUID resortId, Resort resort) {
    return resortService.updateResort(resort);
  }
  @DeleteMapping("/{resortId}")
  public boolean deleteResort(@PathVariable UUID resortId) {
    return resortService.deleteResort(resortId);
  }

}
