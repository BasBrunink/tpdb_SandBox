package org.tpdb.backend.monolith.backend.company;

import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import org.tpdb.backend.monolith.backend.company.dto.CompanyCreateDto;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Log
public class CompanyService {

  private final CompanyRepository companyRepository;
  private static final String SYSTEM = "System";

  public CompanyService(CompanyRepository companyRepository) {
    this.companyRepository = companyRepository;
  }

  public Company createCompany(CompanyCreateDto dto) {
    Company company = Company.builder()
        .name(dto.getName())
        .description(dto.getDescription())
        .website(dto.getWebsite())
        .email(dto.getEmail())
        .companyType(dto.getCompanyType())
        .foundingDate(dto.getFoundingDate())
        .closingDate(dto.getClosingDate())
        .operationalStatus(dto.getOperationalStatus())
        .build();
    company.setCreatedAt(LocalDate.now());
    company.setCreatedBy(SYSTEM); //TODO : Set to Logged in User
    company.setUpdatedAt(LocalDate.now());
    company.setUpdatedBy(SYSTEM); //TODO : Set to Logged in User
    return companyRepository.save(company);
  }
  public List<Company> insertManyCompanies(List<Company> companies) {
    return companyRepository.saveAll(companies);
  }
  public Optional<Company> getCompany(UUID companyId) {
    return companyRepository.findById(companyId);
  }
  public List<Company> getCompanies() {
    return companyRepository.findAll();
  }
  public Company updateCompany(Company company) {
    company.setUpdatedAt(LocalDate.now());
    company.setUpdatedBy(SYSTEM); //TODO : Set to Logged in User
    return companyRepository.save(company);
  }
  public boolean deleteCompany(UUID companyId) {
    try {
      companyRepository.deleteById(companyId);
      return true;
    } catch (Exception e) {
      return false;
    }
  }


}
