package com.sivakov;

import com.sivakov.controller.CompanyController;
import com.sivakov.model.Company;
import com.sivakov.repository.CompanyRepository;
import com.sivakov.service.CompanyService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class CompanyServiceApplicationTests {

	@MockBean
	private  CompanyRepository companyRepository;

	@Mock
	private CompanyService companyService;

	@Mock
	private CompanyController companyController;

	@Autowired
	private MockMvc mockMvc;

	Company company = new Company();
	
	@Before
	public void setUp(){
		company.setId(UUID.randomUUID());
		company.setName("Test Company");
	}

	@Test
	public void testGetCompany() throws Exception {
		List<Company> results = new ArrayList<>();
		results.add(company);
		when(companyService.getAll()).thenReturn(results);

		this.mockMvc.perform(get("/companies")).andExpect(status().isOk());
	}
}
