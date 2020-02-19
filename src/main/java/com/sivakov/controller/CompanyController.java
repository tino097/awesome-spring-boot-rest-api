package com.sivakov.controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;

import com.sivakov.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.sivakov.exception.CompanyException;
import com.sivakov.model.Company;
import com.sivakov.model.ErrorResponse;
import com.sivakov.model.Owner;

/**
 * The type Company controller.
 *
 * @author Tino097
 */
@RestController
public class CompanyController {

	@Autowired
	private CompanyService companyService;

	/**
	 * Gets company.
	 *
	 * @return the company
	 */
	@RequestMapping(value = "/companies", method = RequestMethod.GET)
	public @ResponseBody List<Company> getCompany() {
		List<Company> companies = companyService.getAll();
		return companies;
	}

	/**
	 * Create company company.
	 *
	 * @param company the company
	 * @return the company
	 */
	@RequestMapping(value = "/companies/add", method = RequestMethod.POST)
	public @ResponseBody Company createCompany(@RequestBody @Valid Company company) {
		return companyService.save(company);
	}

	/**
	 * Gets company.
	 *
	 * @param id the id
	 * @return the company
	 */
	@RequestMapping(value = "/companies/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Company getCompanyById(@PathVariable Long id) {
		return companyService.getCompanyById(id);
	}

	/**
	 * Edit company company.
	 *
	 * @param company the company
	 * @param id      the id
	 * @return the company
	 */
	@RequestMapping(value = "/companies/{id}", method = RequestMethod.POST)
	public @ResponseBody Company editCompany(@RequestBody Company company, @PathVariable Long id) {
		Company existing = companyService.getCompanyById(id);
		existing.setName(company.getName());
		existing.setAddress(company.getAddress());
		existing.setCity(company.getCity());
		existing.setCountry(company.getCountry());
		// this is a partial update, just to show that REST service will work
		return companyService.update(existing);
	}

	/**
	 * Add owner company.
	 *
	 * @param owner the owner
	 * @param id    the id
	 * @return the company
	 */
	@RequestMapping(value = "/companies/{id}/addOwner", method = RequestMethod.POST)
	public @ResponseBody Company addOwner(@RequestBody Owner owner, @PathVariable Long id) {
		Company existing = companyService.getCompanyById(id);
		existing.setOwner(owner);
		return companyService.update(existing);
	}

	@RequestMapping(value = "/companies/findBy", method = RequestMethod.GET)
	public @ResponseBody List<Company> getCompaniesByIndustry(@RequestParam(value="industryId") Long industryId){
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
