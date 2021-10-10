package com.sivakov.controller;

import com.sivakov.Application;
import com.sivakov.model.Company;
import com.sivakov.model.Industry;
import com.sivakov.repository.CompanyRepository;
import com.sivakov.service.CompanyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
class CompanyControllerTests {

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

		company.setIndustries(Set.of(industry, industry2, industry3));
	}

	@Test
	void testGetCompany() throws Exception {
		when(companyService.getAll()).thenReturn(List.of(company));

		this.mockMvc.perform(get("/companies")).andExpect(status().isOk());
	}

	@Test
	void testGetCompanyByIndustryId() throws Exception{
		when(companyService.getCompaniesByIndustry(anyLong())).thenReturn(List.of(company));

		this.mockMvc.perform(get("/companies/findBy?industryId=1"))
				.andDo(print())
				.andExpect(status().isOk());
	}
}
