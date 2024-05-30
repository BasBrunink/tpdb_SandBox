package org.tpdb.backend.monolith.backend.ride;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

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
