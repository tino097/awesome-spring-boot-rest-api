package com.sivakov.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * @author tino097
 **/
@Entity
public class Industry {

    @Id
    @GeneratedValue(generator = "UUID")
    private Long id;

    @NotNull
    private String name;

    private String description;

    @ManyToMany(mappedBy = "industries")
    @JsonIgnore
    private List<Company> companies = new ArrayList<>();

    public Industry() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }

    @Override
    public String toString() {
        return "Industry{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", companies=" + companies +
                '}';
    }
}
