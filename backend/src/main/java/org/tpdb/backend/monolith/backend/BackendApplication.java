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
import org.tpdb.backend.monolith.backend.ride.*;
import org.tpdb.backend.monolith.backend.ride.models.*;
import org.tpdb.backend.monolith.backend.ride.types.RollerCoasterType;
import org.tpdb.backend.monolith.backend.ride.types.flatRideType.FlatRideType;
import org.tpdb.backend.monolith.backend.ride.types.flatRideType.FlatRideTypeService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Log
@SpringBootApplication
public class BackendApplication implements CommandLineRunner {


  private final ParkService parkService;
  private final ResortService resortService;
  private final CompanyService companyService;
  private final RideService rideService;
  private final FlatRideTypeService flatRideTypeService;

  public BackendApplication(ParkService parkService, ResortService resortService, CompanyService companyService, RideService rideService, FlatRideTypeService flatRideTypeService) {
    this.parkService = parkService;
    this.resortService = resortService;
    this.companyService = companyService;
    this.rideService = rideService;
    this.flatRideTypeService = flatRideTypeService;
  }

  public static void main(String[] args) {
    SpringApplication.run(BackendApplication.class, args);
  }

  @Override
  public void run(String... args) {

    seedFlatRideTypes();
    List<Company> seededCompanies = seedCompanies();
    Company company = seededCompanies.stream().findFirst().orElse(null);

    List<Ride> seededRides  = seedRides();
    List<Park> seededParks = seedParks(company);
    List<Resort> seededResorts = seedResorts(company);

    AddRidesToPark(seededParks.stream().filter(x -> x.getName() == "Europa Park").findFirst().orElse(null)  , seededRides);
  }

  private void seedFlatRideTypes() {
    List<FlatRideType> types = Arrays.asList(
        FlatRideType.builder()
            .name("Carousel (Merry-Go-Round)")
            .description("A circular ride with seats, usually in the form of horses or other animals, that move up and down as the platform rotates Example: King Arthur Carrousel at Disneyland.")
            .build(),
        FlatRideType.builder()
            .name("Swing Ride (Chair-O-Planes)")
            .description("Chairs suspended from a rotating top that tilts, causing the chairs to swing outward. Example: Silly Symphony Swings at Disney California Adventure.")
            .build(),
        FlatRideType.builder()
            .name("Ferris Wheel")
            .description("A large vertical rotating wheel with passenger cabins attached along the rim, offering panoramic views. Example: London Eye.")
            .build(),
        FlatRideType.builder()
            .name("Tilt-A-Whirl")
            .description("Cars mounted on pivot points along a rotating platform, which undulates, causing the cars to spin unpredictably. Example: Classic Tilt-A-Whirl rides found at many amusement parks.")
            .build(),
        FlatRideType.builder()
            .name("Scrambler (Twister)")
            .description("Consists of several arms rotating around a central point, with each arm also spinning independently. Example: Scrambler rides at Six Flags parks.")
            .build(),
        FlatRideType.builder()
            .name("Top Spin")
            .description("A ride where passengers are seated in rows on a platform that rotates around a horizontal axis, often with added water or fire effects. Example: Talocan at Phantasialand.")
            .build(),
        FlatRideType.builder()
            .name("Breakdance")
            .description("Rotating platforms mounted on a larger rotating base, with individual cars that spin freely. Example: Breakdance rides at various European amusement parks.")
            .build(),
        FlatRideType.builder()
            .name("Himalaya")
            .description("A ride where cars travel along a circular, undulating track, often with music and lights to enhance the experience. Example: Music Express rides found at many amusement parks.")
            .build(),
        FlatRideType.builder()
            .name("Drop Tower")
            .description("Riders are lifted to a great height and then dropped in a free-fall, often followed by bouncing or additional drops. Example: Tower of Terror at various Disney parks.")
            .build(),
        FlatRideType.builder()
            .name("Pendulum Ride")
            .description("A large arm swings back and forth, with seats at the end that also rotate, creating a pendulum motion. Example: MaXair at Cedar Point.")
            .build(),
        FlatRideType.builder()
            .name("Disk'O")
            .description("A circular platform with outward-facing seats rotates and moves back and forth along a half-pipe track. Example: Disk'O rides at Six Flags parks.")
            .build(),
        FlatRideType.builder()
            .name("Flying Carpet")
            .description("A ride where a large platform swings back and forth in a circular motion, creating a flying sensation. Example: Aladdin's Magic Carpet ride at various parks.")
            .build(),
        FlatRideType.builder()
            .name("Magic Teacups")
            .description("Guests sit in cup-shaped vehicles that spin individually while the entire ride platform also spins. Example: Mad Tea Party at Disneyland.")
            .build(),
        FlatRideType.builder()
            .name("Enterprise")
            .description("Gondolas mounted on a rotating wheel that tilt to a vertical position, creating high G-forces as the wheel spins. Example: Enterprise rides at various amusement parks.")
            .build(),
        FlatRideType.builder()
            .name("Swinging Ship (Pirate Ship)")
            .description("A large ship-shaped vehicle that swings back and forth like a pendulum. Example: Pirate Ship rides at numerous parks worldwide.")
            .build(),
        FlatRideType.builder()
            .name("Swinging Inverter Ship")
            .description("Similar to a swinging ship, but capable of performing full 360-degree loops. Example: Looping Starship at Six Flags parks.")
            .build(),
        FlatRideType.builder()
            .name("Wave Swinger")
            .description("A swing ride with a rotating top that tilts and swings the riders in a wave-like motion. Example: Wave Swinger rides at many theme parks.")
            .build(),
        FlatRideType.builder()
            .name("Paratrooper")
            .description("Seats are attached to arms that lift and rotate, giving the sensation of parachuting. Example: Paratrooper rides at regional fairs and amusement parks.")
            .build(),
        FlatRideType.builder()
            .name("Sizzler (Twist)")
            .description("A ride with several rotating arms, each holding clusters of seats, spinning guests around rapidly. Example: Sizzler rides found at local fairs and parks.")
            .build(),
        FlatRideType.builder()
            .name("Spider (Octopus)")
            .description("A ride with multiple arms that lift and rotate, with each arm supporting a cluster of seats that spin independently. Example: Spider rides at various amusement parks.")
            .build()
    );
    flatRideTypeService.insertManyFlatRideTypes(types);
  }

  private void AddRidesToPark(Park park, List<Ride> seededRides) {
    park.setRides(seededRides);
    parkService.updatePark(park);
    seededRides.forEach(ride -> {
      ride.setPark(park);
      rideService.updateRide(ride);
    });

  }

  private List<Ride> seedRides() {
    List<Ride> rides = new ArrayList<>();
    RollerCoaster blueFire = RollerCoaster.builder()
        .rollerCoasterType(RollerCoasterType.LAUNCHED)
        .numberOfInversions(4)
        .build();
    blueFire.setName("Blue Fire");
    blueFire.setNumberOfInversions(4);
    blueFire.setCapacity(1720);
    blueFire.setLength(1050);
    rides.add(blueFire);


    DarkRide darkRide = DarkRide.builder()
        .length(1000)
        .theme("Pirates")
        .darkRideType(null)
        .build();
    darkRide.setName("Pirates of the Caribbean");

    rides.add(rideService.createRide(darkRide));




    FlatRide flatRide =  new FlatRide();
    flatRide.setName("Tea Cups");

    rides.add(rideService.createRide(flatRide));
    return rides;


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
