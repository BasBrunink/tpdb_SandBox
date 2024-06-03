package org.tpdb.backend.monolith.backend.ride.models.attributes.darkridescene;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.tpdb.backend.monolith.backend.ride.darkride.DarkRideService;
import org.tpdb.backend.monolith.backend.ride.models.attributes.darkridescene.dto.DarkRideSceneCreateDto;

import java.util.UUID;

@Service
public class DarkRideSceneService {
  private final DarkRideSceneRepository darkRideSceneRepository;
  private final DarkRideService darkRideService;

  public DarkRideSceneService(DarkRideSceneRepository darkRideSceneRepository, DarkRideService darkRideService) {
    this.darkRideSceneRepository = darkRideSceneRepository;
    this.darkRideService = darkRideService;
  }

  public DarkRideScene createDarkRideScene(DarkRideSceneCreateDto darkRideSceneCreateDto) {
    DarkRideScene darkRideScene = DarkRideScene.builder()
      .darkRide(darkRideService.getById(darkRideSceneCreateDto.getDarkRideId()).orElse(null))
      .name(darkRideSceneCreateDto.getName())
      .description(darkRideSceneCreateDto.getDescription())
      .index(darkRideSceneCreateDto.getIndex())
      .build();
    return darkRideSceneRepository.save(darkRideScene);
  }


}
