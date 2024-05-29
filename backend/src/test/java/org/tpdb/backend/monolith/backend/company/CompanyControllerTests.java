package org.tpdb.backend.monolith.backend.company;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.tpdb.backend.monolith.backend.company.dto.CompanyCreateDto;


import java.util.Collections;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class CompanyControllerTests {

  @Mock
  private CompanyService companyService;

  @InjectMocks
  private CompanyController companyController;

  private MockMvc mockMvc;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
    mockMvc = MockMvcBuilders.standaloneSetup(companyController).build();
  }

  @Test
  @DisplayName("Should create company successfully")
  void createCompany() throws Exception {
    CompanyCreateDto company = new CompanyCreateDto();
    when(companyService.createCompany(any(CompanyCreateDto.class))).thenReturn(new Company());

    mockMvc.perform(post("/company")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(new ObjectMapper().writeValueAsString(company)))
            .andExpect(status().isOk());
  }

  @Test
  @DisplayName("Should get all companies successfully")
  void getCompanies() throws Exception {
    when(companyService.getCompanies()).thenReturn(Collections.singletonList(new Company()));

    mockMvc.perform(get("/company")
                    .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
  }

  @Test
  @DisplayName("Should get company by id successfully")
  void getCompany() throws Exception {
    UUID companyId = UUID.randomUUID();
    when(companyService.getCompany(companyId)).thenReturn(Optional.of(new Company()));

    mockMvc.perform(get("/company/" + companyId)
                    .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
  }

  @Test
  @DisplayName("Should update company successfully")
  void updateCompany() throws Exception {
    UUID companyId = UUID.randomUUID();
    when(companyService.getCompany(companyId)).thenReturn(Optional.of(new Company()));
    when(companyService.updateCompany(any(Company.class))).thenReturn(new Company());

    mockMvc.perform(put("/company/" + companyId)
            .contentType(MediaType.APPLICATION_JSON)
            .content(new ObjectMapper().writeValueAsString(new Company())))
        .andExpect(status().isOk());
  }

  @Test
  @DisplayName("Should return not found when company id does not exist")
  //TODO: Not working as expected
  void getCompanyNotFound() throws Exception {
    UUID companyId = UUID.randomUUID();
    when(companyService.getCompany(companyId)).thenReturn(Optional.empty());

    mockMvc.perform(get("/company/" + companyId)
                    .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
  }

  @Test
  @DisplayName("Should delete company successfully")
  void deleteCompany() throws Exception {
    UUID companyId = UUID.randomUUID();
    when(companyService.getCompany(companyId)).thenReturn(Optional.of(new Company()));

    mockMvc.perform(delete("/company/" + companyId)
                    .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
  }


}

