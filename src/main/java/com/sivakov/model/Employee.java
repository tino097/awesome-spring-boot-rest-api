/**
 * 
 */
package com.sivakov.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.UUID;

/**
 * @author Tino097
 *
 */

@Entity
public class Employee {

	@Id
	@GeneratedValue(generator = "UUID")
	private UUID id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="employee_id")
	@JsonIgnore
	private Company company;

	private String name;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}