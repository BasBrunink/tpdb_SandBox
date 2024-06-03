package org.tpdb.backend.monolith.backend.common.models;

import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Location extends BaseModel{
  private String street;
  private String city;
  private String state;
  private String postalCode;
  private String country;

  // Fields for GPS data
  private double latitude;
  private double longitude;


}
