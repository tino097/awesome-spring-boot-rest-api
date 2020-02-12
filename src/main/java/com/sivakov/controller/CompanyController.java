package com.sivakov.controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;

import com.sivakov.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sivakov.exception.CompanyException;
import com.sivakov.model.Company;
import com.sivakov.model.ErrorResponse;
import com.sivakov.model.Owner;

/**
 * @author Tino097
 *
 */

@RestController
public class CompanyController {

	@Autowired
	private CompanyService companyService;

	@RequestMapping(value = "/companies", method = RequestMethod.GET)
	public @ResponseBody List<Company> getCompany() {
		List<Company> companies = companyService.getAll();
		return companies;
	}

	@RequestMapping(value = "/companies/add", method = RequestMethod.POST)
	public @ResponseBody Company createCompany(@RequestBody @Valid Company company) {
		return companyService.save(company);
	}

	@RequestMapping(value = "/companies/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Company getCompany(@PathVariable Long id) {
		return companyService.getCompanyById(id);
	}

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

	@RequestMapping(value = "/companies/{id}/addOwner", method = RequestMethod.POST)
	public @ResponseBody Company addOwner(@RequestBody Owner owner, @PathVariable Long id) {
		Company existing = companyService.getCompanyById(id);
		Set<Owner> owners = existing.getOwners();
		owners.add(owner);
		existing.setOwners(owners);
		return companyService.update(existing);
	}

	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public @ResponseBody ErrorResponse handleUException(CompanyException e) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setStatus(String.valueOf(HttpStatus.BAD_REQUEST));
		errorResponse.setMessage(e.getMessage());
		return errorResponse;
	}
}
