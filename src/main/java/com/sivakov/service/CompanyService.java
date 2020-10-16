package com.sivakov.service;

import com.sivakov.model.Company;
import com.sivakov.model.Owner;
import com.sivakov.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.UUID;


/**
 * The type Company service.
 *
 * @author tino097
 */
@Service
@Validated
public class CompanyService extends CrudService<Company, UUID, CompanyRepository> {

    private final OwnerService ownerService;

    @Autowired
    protected CompanyService(CompanyRepository repository, OwnerService ownerService) {
        super(repository);
        this.ownerService = ownerService;
    }

    /**
     * Get Companies by industryId
     *
     * @param industryId industry's ID
     * @return List of companies
     */
    public List<Company> getCompaniesByIndustry(Long industryId) {
        return repository.findByIndustriesId(industryId);
    }

    /**
     * Edit company
     *
     * @param company to edit
     * @param id company's id
     * @return edited company
     */
    public Company editCompany(Company company, UUID id) {
        Company existing = getById(id);
        existing.setName(company.getName());
        existing.setAddress(company.getAddress());
        existing.setCity(company.getCity());
        existing.setCountry(company.getCountry());
        return existing;
    }

    /**
     * Add owner
     * @param id of company
     * @param ownerId id of owner
     * @return edited company
     */
    public Company addOwner(UUID id, UUID ownerId) {
        Company existing = getById(id);
        Owner owner = ownerService.getById(ownerId);
        existing.setOwner(owner);
        return existing;
    }
}
