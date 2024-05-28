package org.tpdb.backend.monolith.backend.park;

import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import org.tpdb.backend.monolith.backend.park.dto.ParkCreateDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Log
public class ParkService {

  private final ParkRepository parkRepository;

  public ParkService(ParkRepository parkRepository) {
    this.parkRepository = parkRepository;
  }

  public Park createPark(ParkCreateDto parkDto) {
    log.info("Creating Park: " + parkDto.getName());

    Park park = Park.builder()
        .name(parkDto.getName())
        .parkType(parkDto.getParkType())
        .company(parkDto.getCompany())
        .openingDate(parkDto.getOpeningDate())
        .closingDate(parkDto.getClosingDate())
        .operationalStatus(parkDto.getOperationalStatus())
        .build();
    return parkRepository.save(park);
  }

  public List<Park> insertManyParks(List<Park> parks) {
    return parkRepository.saveAll(parks);
  }

  public Optional<Park> getPark(UUID parkId) {
    return parkRepository.findById(parkId);
  }
  public List<Park> getParks() {
    return parkRepository.findAll();
  }
  public Park updatePark(Park park) {
    return parkRepository.save(park);
  }
  public boolean deletePark(UUID parkId) {
    try {
      parkRepository.deleteById(parkId);
      return true;
    } catch (Exception e) {
      return false;
    }



  }
}
