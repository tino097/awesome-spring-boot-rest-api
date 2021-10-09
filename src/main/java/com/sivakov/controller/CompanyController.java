package com.sivakov.controller;

import com.sivakov.exception.CompanyException;
import com.sivakov.model.Company;
import com.sivakov.model.ErrorResponse;
import com.sivakov.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

/**
 * The type Company controller.
 *
 * @author Tino097
 */
@RestController
@RequestMapping("/companies")
public class CompanyController {

	@Autowired
	private CompanyService companyService;

	/**
	 * Gets company.
	 *
	 * @return the company
	 */
	@GetMapping
	public List<Company> getCompany() {
		return companyService.getAll();
	}

	/**
	 * Create company company.
	 *
	 * @param company the company
	 * @return the company
	 */
	@PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Company createCompany(@RequestBody @Valid Company company) {
		company.setId(UUID.randomUUID());
		return companyService.save(company);
	}

	/**
	 * Gets company.
	 *
	 * @param id the id
	 * @return the company
	 */
	@GetMapping("/{id}")
	public Company getCompanyById(@PathVariable UUID id) {
		return companyService.getById(id);
	}

	/**
	 * Edit company company.
	 *
	 * @param company the company
	 * @param id      the id
	 * @return the company
	 */
	@PutMapping("/{id}")
	public Company editCompany(@RequestBody Company company, @PathVariable UUID id) {
		return companyService.editCompany(company, id);
	}

	/**
	 * Add owner company.
	 *
	 * @param id    the id
	 * @param ownerId the owner's id
	 * @return the company
	 */
	@PostMapping("/{id}/{ownerId}")
	public Company addOwner(@PathVariable UUID id, @PathVariable UUID ownerId) {
		return companyService.addOwner(id, ownerId);
	}

	//This feature should be located in the 'industry' controller
	@GetMapping(value = "/findBy")
	public List<Company> getCompaniesByIndustry(@RequestParam(value="industryId") Long industryId){
		return companyService.getCompaniesByIndustry(industryId);
	}

	/**
	 * Handle u exception error response.
	 *
	 * @param e the e
	 * @return the error response
	 */
	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public @ResponseBody ErrorResponse handleUException(CompanyException e) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setStatus(String.valueOf(HttpStatus.BAD_REQUEST));
		errorResponse.setMessage(e.getMessage());
		return errorResponse;
	}
}
