package org.tpdb.backend.monolith.backend.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.tpdb.backend.monolith.backend.company.dto.CompanyCreateDto;


import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class CompanyServiceTests {

  @Mock
  private CompanyRepository companyRepository;

  @InjectMocks
  private CompanyService companyService;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  @DisplayName("Should create company successfully")
  void createCompany() {
    CompanyCreateDto companyDto = new CompanyCreateDto();
    Company company = new Company();
    when(companyRepository.save(any(Company.class))).thenReturn(company);

    Company result = companyService.createCompany(companyDto);

    assertEquals(company, result);
  }

  @Test
  @DisplayName("Should get all companies successfully")
  void getCompanies() {
    when(companyRepository.findAll()).thenReturn(Collections.singletonList(new Company()));

    List<Company> result = companyService.getCompanies();

    assertEquals(1, result.size());
  }

  @Test
  @DisplayName("Should get company by id successfully")
  void getCompany() {
    UUID companyId = UUID.randomUUID();
    when(companyRepository.findById(companyId)).thenReturn(Optional.of(new Company()));

    Optional<Company> result = companyService.getCompany(companyId);

    assertTrue(result.isPresent());
  }

  @Test
  @DisplayName("Should update company successfully")
  void updateCompany() {
    UUID companyId = UUID.randomUUID();
    Company company = new Company();
    when(companyRepository.findById(companyId)).thenReturn(Optional.of(company));
    when(companyRepository.save(any(Company.class))).thenReturn(company);

    Company result = companyService.updateCompany(new Company());

    assertEquals(company, result);
  }

  @Test
  @DisplayName("Should return empty when company id does not exist")
  void getCompanyNotFound() {
    UUID companyId = UUID.randomUUID();
    when(companyRepository.findById(companyId)).thenReturn(Optional.empty());

    Optional<Company> result = companyService.getCompany(companyId);

    assertFalse(result.isPresent());
  }

  @Test
  @DisplayName("Should delete company successfully")
  void deleteCompany() {
    UUID companyId = UUID.randomUUID();

    doNothing().when(companyRepository).deleteById(companyId);

    boolean result = companyService.deleteCompany(companyId);

    assertTrue(result);
  }

}
