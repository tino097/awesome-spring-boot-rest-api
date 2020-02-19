/**
 * 
 */
package com.sivakov.model;


import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @author Tino097
 *
 */
@Entity
public class Company {

	@Id
	@GeneratedValue(generator = "UUID")
	private UUID id;

	@NotNull
	private String name;

	@NotNull
	private String address;

	@NotNull
	private String city;

	@NotNull
	private String country;

	private String email;

	private String phoneNumber;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "company", fetch = FetchType.LAZY)
	private Set<Employee> employees = new HashSet<Employee>();

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "company", fetch = FetchType.LAZY)
	private Owner owner;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "company_industry", joinColumns = @JoinColumn(name = "company_id"),
			inverseJoinColumns = @JoinColumn(name = "industry_id"),
			uniqueConstraints = @UniqueConstraint(columnNames ={"company_id", "industry_id"}))
	private Set<Industry> industries = new HashSet<>();

	public Company() {
		// TODO Auto-generated constructor stub
	}

	public Company(UUID id, @NotNull String name, @NotNull String address, @NotNull String city, @NotNull String country, String email, String phoneNumber, Set<Employee> employees, Owner owner, Set<Industry> industries) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.city = city;
		this.country = country;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.employees = employees;
		this.owner = owner;
		this.industries = industries;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public Set<Industry> getIndustries() {
		return industries;
	}

	public void setIndustries(Set<Industry> industries) {
		this.industries = industries;
	}

	@Override
	public String toString() {
		return "Company{" +
				"id=" + id +
				", name='" + name + '\'' +
				", address='" + address + '\'' +
				", city='" + city + '\'' +
				", country='" + country + '\'' +
				", email='" + email + '\'' +
				", phoneNumber='" + phoneNumber + '\'' +
				", employees=" + employees +
				", owner=" + owner +
				", industries=" + industries +
				'}';
	}
}
