package org.tpdb.backend.monolith.backend.company;


import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;
import org.tpdb.backend.monolith.backend.company.dto.CompanyCreateDto;

import java.util.List;
import java.util.UUID;

@RestController()
@RequestMapping("/company")
@Log
public class CompanyController {

  private final CompanyService companyService;

  public CompanyController(CompanyService companyService) {
    this.companyService = companyService;
  }

  @PostMapping()
  public Company createCompany(@RequestBody CompanyCreateDto company) {
    log.info("Creating Company: " + company.getName());
    return companyService.createCompany(company);
  }

  @GetMapping()
  public List<Company> getCompanies() {
    return companyService.getCompanies();
  }

  @GetMapping("/{companyId}")
  public Company getCompany(@PathVariable UUID companyId) {
    return companyService.getCompany(companyId).orElse(null);
  }

  @PutMapping("/{companyId}")
  public Company updateCompany(@PathVariable UUID companyId, Company company) {
    return companyService.updateCompany(company);
  }

  @DeleteMapping("/{companyId}")
  public boolean deleteCompany(@PathVariable UUID companyId) {
    return companyService.deleteCompany(companyId);
  }
}

