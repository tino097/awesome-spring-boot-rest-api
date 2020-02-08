package com.sivakov;

import com.sivakov.controller.CompanyController;
import com.sivakov.model.Company;
import com.sivakov.repository.CompanyRepository;
import com.sivakov.service.CompanyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CompanyServiceApplication.class)
@ActiveProfiles("test")
public class CompanyServiceApplicationTests {

	@MockBean
	private  CompanyRepository companyRepository;

	@Mock
	private CompanyService companyService;

	@Mock
	private CompanyController companyController;

	MockMvc mockMvc;

	@Test
	public void testGetCompany() throws Exception {
		List<Company> results = new ArrayList<>();
		results.add(new Company());
		when(companyService.getAll()).thenReturn(results);

		mockMvc.perform(get("/companies")).andExpect(status().isOk());
	}
}
