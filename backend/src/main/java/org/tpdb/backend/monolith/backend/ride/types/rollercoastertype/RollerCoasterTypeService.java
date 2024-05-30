package org.tpdb.backend.monolith.backend.ride.types.rollercoastertype;

public class RollerCoasterTypeService {

  private final RollerCoasterTypeRepository rollerCoasterTypeRepository;

  public RollerCoasterTypeService(RollerCoasterTypeRepository rollerCoasterTypeRepository) {
    this.rollerCoasterTypeRepository = rollerCoasterTypeRepository;
  }
}
