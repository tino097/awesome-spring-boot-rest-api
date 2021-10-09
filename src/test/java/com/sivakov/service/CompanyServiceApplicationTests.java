package com.sivakov.service;

import com.sivakov.Application;
import com.sivakov.controller.CompanyController;
import com.sivakov.model.Company;
import com.sivakov.model.Industry;
import com.sivakov.repository.CompanyRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.*;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(classes = Application.class)
@ActiveProfiles("test")
@AutoConfigureMockMvc
class CompanyServiceApplicationTests {

	@MockBean
	private  CompanyRepository companyRepository;

	@Mock
	private CompanyService companyService;

	@Mock
	private CompanyController companyController;

	@Autowired
	private MockMvc mockMvc;

	Company company = new Company();
	Industry industry = new Industry();
	Industry industry2 = new Industry();
	Industry industry3 = new Industry();



	@BeforeEach
	void setUp(){
		company.setId(UUID.randomUUID());
		company.setName("Test Company");

		industry.setId(1L);
		industry.setName("Marketing");

		industry2.setId(2L);
		industry2.setName("Travel");

		industry3.setId(3L);
		industry3.setName("Food");

		Set<Industry> industries = new HashSet<>();
		industries.add(industry);
		industries.add(industry2);
		industries.add(industry);
		company.setIndustries(industries);
	}

	@Test
	void testGetCompany() throws Exception {
		List<Company> results = new ArrayList<>();
		results.add(company);
		when(companyService.getAll()).thenReturn(results);

		this.mockMvc.perform(get("/companies")).andExpect(status().isOk());
	}

	@Test
	void testGetCompanyByIndustryId() throws Exception{
		List<Company> results = new ArrayList<>();
		results.add(company);
		when(companyService.getCompaniesByIndustry(1L)).thenReturn(results);

		System.out.println(results);

		this.mockMvc.perform(get("/companies/findBy?industryId=1"))
				.andDo(print())
				.andExpect(status().isBadRequest());
	}
}
