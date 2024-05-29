package org.tpdb.backend.monolith.backend;

import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.tpdb.backend.monolith.backend.common.enums.OperationalStatus;
import org.tpdb.backend.monolith.backend.park.Park;
import org.tpdb.backend.monolith.backend.park.ParkService;
import org.tpdb.backend.monolith.backend.park.ParkType;
import org.tpdb.backend.monolith.backend.resort.Resort;
import org.tpdb.backend.monolith.backend.resort.ResortService;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Log
@SpringBootApplication
public class BackendApplication implements CommandLineRunner {


  private final ParkService parkService;
  private final ResortService resortService;

  public BackendApplication(ParkService parkService, ResortService resortService) {
    this.parkService = parkService;
    this.resortService = resortService;
  }

  public static void main(String[] args) {
    SpringApplication.run(BackendApplication.class, args);
  }

  String mackFamily = "Mack Family";
  @Override
  public void run(String... args) {
    List<Park> seededParks = seedParks();
    List<Resort> seededResorts = seedResorts();

  }

  private List<Resort> seedResorts() {
    List<Resort> resorts = Arrays.asList(
        Resort.builder()
            .name("Europa Park Resort")
            .owner(mackFamily)
            .operator(mackFamily)
            .openingDate(LocalDate.of(1975, 7, 12))
            .closingDate(null)
            .operationalStatus(OperationalStatus.OPEN)
            .build()
    );
    return resortService.insertManyResorts(resorts);
  }
  private List<Park> seedParks() {
    List<Park> parks = Arrays.asList(
        Park.builder()
            .name("Europa Park")
            .owner(mackFamily)
            .operator(mackFamily)
            .openingDate(LocalDate.of(1975, 7, 12))
            .closingDate(null)
            .operationalStatus(OperationalStatus.OPEN)
            .parkType(ParkType.THEME_PARK)
            .build(),
        Park.builder()
            .name("Rulantica")
            .owner(mackFamily)
            .operator(mackFamily)
            .openingDate(LocalDate.of(2019, 7, 12))
            .closingDate(null)
            .operationalStatus(OperationalStatus.OPEN)
            .parkType(ParkType.WATER_PARK)
            .build()
    );
    return parkService.insertManyParks(parks);
  }
}
