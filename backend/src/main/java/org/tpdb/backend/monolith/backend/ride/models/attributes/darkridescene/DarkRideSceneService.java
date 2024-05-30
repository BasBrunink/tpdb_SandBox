package org.tpdb.backend.monolith.backend.ride.models.attributes.darkridescene;

import jakarta.persistence.EntityNotFoundException;
import org.tpdb.backend.monolith.backend.ride.models.attributes.darkridescene.dto.DarkRideSceneCreateDto;

import java.util.UUID;

public class DarkRideSceneService {
  private final DarkRideSceneRepository darkRideSceneRepository;

  public DarkRideSceneService(DarkRideSceneRepository darkRideSceneRepository) {
    this.darkRideSceneRepository = darkRideSceneRepository;
  }
}
