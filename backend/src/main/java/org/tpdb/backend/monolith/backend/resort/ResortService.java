package org.tpdb.backend.monolith.backend.resort;

import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import org.tpdb.backend.monolith.backend.resort.dto.ResortCreateDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Log
public class ResortService {
  private final ResortRepository resortRepository;

  public ResortService(ResortRepository resortRepository) {
    this.resortRepository = resortRepository;
  }
  public Resort createResort(ResortCreateDto resortDto) {
    log.info("Creating Resort: " + resortDto.getName());
    Resort resort = Resort.builder()
        .name(resortDto.getName())
        .operator(resortDto.getOperator())
        .owner(resortDto.getOwner())
        .openingDate(resortDto.getOpeningDate())
        .closingDate(resortDto.getClosingDate())
        .operationalStatus(resortDto.getOperationalStatus())
        .build();
    return resortRepository.save(resort);
  }

  public List<Resort> insertManyResorts(List<Resort> resorts) {
    return resortRepository.saveAll(resorts);
  }

  public List<Resort> getResorts() {
    return resortRepository.findAll();
  }
  public Optional<Resort> getResort(UUID resortId) {
    return resortRepository.findById(resortId);
  }
  public Resort updateResort(Resort resort) {
    return resortRepository.save(resort);
  }

  public boolean deleteResort(UUID resortId) {
    try {
      resortRepository.deleteById(resortId);
      return true;
    } catch (Exception e) {
      return false;
    }
  }


}
