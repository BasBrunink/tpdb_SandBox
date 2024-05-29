package org.tpdb.backend.monolith.backend;

import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.tpdb.backend.monolith.backend.common.enums.OperationalStatus;
import org.tpdb.backend.monolith.backend.company.Company;
import org.tpdb.backend.monolith.backend.company.CompanyService;
import org.tpdb.backend.monolith.backend.company.CompanyType;
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
public class BackendApplication {




    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }




}
