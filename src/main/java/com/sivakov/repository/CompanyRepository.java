package com.sivakov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sivakov.model.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

}
