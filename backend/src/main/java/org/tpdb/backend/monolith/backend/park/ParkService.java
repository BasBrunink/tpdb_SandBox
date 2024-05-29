package org.tpdb.backend.monolith.backend.park;

import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import org.tpdb.backend.monolith.backend.park.dto.ParkCreateDto;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Log
public class ParkService {

  private final ParkRepository parkRepository;

  private final static String SYSTEM = "System";

  public ParkService(ParkRepository parkRepository) {
    this.parkRepository = parkRepository;
  }

  public Park createPark(ParkCreateDto parkDto) {




    Park park = Park.builder()
        .name(parkDto.getName())
        .parkType(parkDto.getParkType())
        .operator(parkDto.getOperator())
        .owner(parkDto.getOwner())
        .openingDate(parkDto.getOpeningDate())
        .closingDate(parkDto.getClosingDate())
        .operationalStatus(parkDto.getOperationalStatus())
        .build();
    park.setCreatedAt(LocalDate.now());
    park.setCreatedBy(SYSTEM); //TODO : Set to Logged in User
    park.setUpdatedAt(LocalDate.now());
    park.setUpdatedBy(SYSTEM); //TODO : Set to Logged in User
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
    park.setUpdatedAt(LocalDate.now());
    park.setUpdatedBy(SYSTEM); //TODO : Set to Logged in User
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
