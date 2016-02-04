package com.sivakov.service;

import java.util.List;

import javax.transaction.Transactional;

import org.neo4j.cypher.internal.compiler.v2_1.ast.rewriters.reattachAliasedExpressions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.sivakov.exception.CompanyException;
import com.sivakov.model.Company;
import com.sivakov.repository.CompanyRepository;

import scala.annotation.cloneable;

/**
 * @author Tino097
 *
 */
@Service
@Validated
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyRepository companyRepository;

	public CompanyServiceImpl() {
	}

	@Override
	@Transactional
	public Company save(Company company) {
		// Simple checkout for duplication, not neccessary in this situation
		// yet i treid to implement it as for exception handling
		Company existingCompany = companyRepository.findOne(company.getId());
		if (existingCompany != null) {
			throw new CompanyException("Duplicate company");
		}
		return companyRepository.save(company);
	}

	@Override
	@Transactional
	public List<Company> getAll() {
		return companyRepository.findAll();
	}

	@Override
	public Company getCompanyById(Long id) {
		return companyRepository.findOne(id);
	}

	@Override
	@Transactional
	public Company update(Company company) {
		return companyRepository.save(company);
	}
}
