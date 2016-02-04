/**
 * 
 */
package com.sivakov.service;

import java.util.List;

import com.sivakov.model.Company;

/**
 * @author Tino097
 *
 */
public interface CompanyService {

	Company save(Company company);
	List<Company> getAll();
	Company getCompanyById(Long id);
	Company update(Company company);

}
