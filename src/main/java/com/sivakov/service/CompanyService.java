package com.sivakov.service;

import java.util.List;

import javax.transaction.Transactional;

import com.sivakov.exception.CompanyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.sivakov.model.Company;
import com.sivakov.repository.CompanyRepository;


/**
 * The type Company service.
 * @author tino097
 */
@Service
@Validated
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    /**
     * Instantiates a new Company service.
     */
    public CompanyService() {
    }

    /**
     * Save company.
     *
     * @param company the company
     * @return the company
     */
    @Transactional
    public Company save(Company company) {

        Company companySaved = companyRepository.save(company);
        return companySaved;
    }

    /**
     * Gets all.
     *
     * @return the all
     */
    @Transactional
    public List<Company> getAll() {

        return companyRepository.findAll();
    }

    /**
     * Gets company by id.
     *
     * @param id the id
     * @return the company by id
     */
    public Company getCompanyById(Long id) {

        return companyRepository.findById(id).orElseThrow(()-> new CompanyException("Company not found"));
    }

    /**
     * Update company.
     *
     * @param company the company
     * @return the company
     */
    @Transactional
    public Company update(Company company) {

        return companyRepository.save(company);
    }

    public List<Company> getCompaniesByIndustry(Long industryId){
        return companyRepository.findByIndustriesId(industryId);
    }
}
