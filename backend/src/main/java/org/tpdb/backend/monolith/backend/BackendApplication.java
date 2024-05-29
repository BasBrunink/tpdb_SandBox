package org.tpdb.backend.monolith.backend;

import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.tpdb.backend.monolith.backend.common.enums.OperationalStatus;
import org.tpdb.backend.monolith.backend.company.Company;
import org.tpdb.backend.monolith.backend.company.CompanyService;
import org.tpdb.backend.monolith.backend.park.Park;
import org.tpdb.backend.monolith.backend.park.ParkService;
import org.tpdb.backend.monolith.backend.park.ParkType;
import org.tpdb.backend.monolith.backend.resort.Resort;
import org.tpdb.backend.monolith.backend.resort.ResortService;
import org.tpdb.backend.monolith.backend.ride.DarkRide;
import org.tpdb.backend.monolith.backend.ride.Ride;
import org.tpdb.backend.monolith.backend.ride.RideService;
import org.tpdb.backend.monolith.backend.ride.RollerCoaster;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Log
@SpringBootApplication
public class BackendApplication implements CommandLineRunner {


  private final ParkService parkService;
  private final ResortService resortService;
  private final CompanyService companyService;
  private final RideService rideService;

  public BackendApplication(ParkService parkService, ResortService resortService, CompanyService companyService, RideService rideService) {
    this.parkService = parkService;
    this.resortService = resortService;
    this.companyService = companyService;
    this.rideService = rideService;
  }

  public static void main(String[] args) {
    SpringApplication.run(BackendApplication.class, args);
  }

  @Override
  public void run(String... args) {
    List<Company> seededCompanies = seedCompanies();
    Company company = seededCompanies.stream().findFirst().orElse(null);

    List<Park> seededParks = seedParks(company);
    List<Resort> seededResorts = seedResorts(company);

    seedRides();

  }

  private void seedRides() {
    DarkRide darkRide = DarkRide.builder()
        .length(1000)
        .theme("Pirates")
        .darkRideType(null)
        .build();
    darkRide.setName("Pirates of the Caribbean");
    rideService.createDarkRide(darkRide);
    RollerCoaster rollerCoaster = RollerCoaster.builder()
        .length(1000)
        .height(50)
        .numInversions(3)
        .maxSpeed(100)
        .numDrops(1)
        .build();
    rollerCoaster.setName("Silver Star");
    rideService.createRollerCoaster(rollerCoaster);
  }



  private List<Company> seedCompanies() {
    List<Company> companies= Arrays.asList(
        Company.builder().name("Europa-Park").build()
    );
    return companyService.insertManyCompanies(companies);
  }

  private List<Resort> seedResorts(Company company) {
    List<Resort> resorts = Arrays.asList(
        Resort.builder()
            .name("Europa Park Resort")
            .openingDate(LocalDate.of(1975, 7, 12))
            .owner(company)
            .operator(company)
            .closingDate(null)
            .operationalStatus(OperationalStatus.OPEN)
            .build()
    );
    return resortService.insertManyResorts(resorts);
  }
  private List<Park> seedParks(Company company) {
    List<Park> parks = Arrays.asList(
        Park.builder()
            .name("Europa Park")
            .owner(company)
            .operator(company)
            .openingDate(LocalDate.of(1975, 7, 12))
            .closingDate(null)
            .operationalStatus(OperationalStatus.OPEN)
            .parkType(ParkType.THEME_PARK)
            .build(),
        Park.builder()
            .name("Rulantica")
            .openingDate(LocalDate.of(2019, 7, 12))
            .closingDate(null)
            .operationalStatus(OperationalStatus.OPEN)
            .parkType(ParkType.WATER_PARK)
            .build()
    );
    return parkService.insertManyParks(parks);
  }
}
