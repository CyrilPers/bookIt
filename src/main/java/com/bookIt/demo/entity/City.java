package com.bookIt.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "city")
public class City {
    @Id
    @Column(name = "insee_city", nullable = false)
    private Integer id;

    private String label;

    @ManyToOne(optional = false)
    private County inseeCounty;

    @ManyToOne(optional = false)
    private Country inseeCountry;

    @ManyToOne(optional = false)
    private PostalCode postalCode;
}