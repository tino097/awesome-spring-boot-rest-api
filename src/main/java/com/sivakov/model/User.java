package com.sivakov.model
import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @author Tino097
 *
 */
@Entity
public class User{

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @NotNull
    private String name;

    @NotNull
    private String email;

    @NotNull
    private String password;

    @NotNull
    private String role;

    @NotNull
    private String status;

    @NotNull
    private String phoneNumber;

    @NotNull
    private String address;

    @NotNull
    private String city;

    @NotNull
    private String country;

    @NotNull
    private String zipCode;

    @NotNull
    private String companyName;

    @NotNull
    private String companyAddress;

    @NotNull
    private String companyCity;

    @NotNull
    private String companyCountry;

    @NotNull
    private String companyZipCode;

    @NotNull
    private String companyPhoneNumber;

    @NotNull
    private String companyEmail;

    @NotNull
    private String companyWebsite;

    @NotNull
    private String companyIndustry;

    @NotNull
    private String companySize;

    @NotNull
    private String companyDescription;

    @NotNull
    private String companyLogo;

    @NotNull
    private String companyCover;

    public User() {
        // TODO Auto-generated constructor stub
    }

    // getters and setters
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyCity(String companyCity) {
        this.companyCity = companyCity;
    }

    public String getCompanyCity() {
        return companyCity;
    }
    
}