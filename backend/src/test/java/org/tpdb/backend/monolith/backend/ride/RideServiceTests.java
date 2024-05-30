package org.tpdb.backend.monolith.backend.ride;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.tpdb.backend.monolith.backend.ride.ride.RideRepository;
import org.tpdb.backend.monolith.backend.ride.ride.RideService;

public class RideServiceTests {

  @Mock
  private RideRepository rideRepository;

  @InjectMocks
  private RideService rideService;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

}
