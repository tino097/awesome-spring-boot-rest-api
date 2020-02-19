package com.sivakov.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @author tino097
 **/
@Entity
public class Industry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String name;

    private String description;

    @OneToOne
    private Company company;

}
