/**
 * 
 */
package com.sivakov.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.UUID;

/**
 * @author Tino097
 *
 */
@Entity
public class Owner {

	@Id
	@GeneratedValue(generator = "UUID")
	private UUID id;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="owner_id")
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
