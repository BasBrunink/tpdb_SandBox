package org.tpdb.backend.monolith.backend.company;


import lombok.Getter;

@Getter
public enum CompanyType {

  OWNER("Owner"),
  OPERATOR("Operator"),
  DEVELOPERS("Developers"),
  MANUFACTURER("Manufacturer"),
  SHOW_PRODUCTION("Show Production"),
  FOOD_PROVIDER("Food Provider"),
  SERVICE_PROVIDER("Service Provider"),
  MERCHANDISE("Merchandise"),
  TECHNOLOGY_PROVIDER("Technology Provider"),
  HOSPITALITY("Hospitality"),
  MAINTENANCE_PROVIDER("Maintenance Provider");

  private final String fullName;

  CompanyType(String fullName) {
    this.fullName = fullName;
  }
}
