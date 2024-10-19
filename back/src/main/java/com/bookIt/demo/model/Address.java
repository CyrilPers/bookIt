package com.bookIt.demo.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(optional = false)
    private City city;

    private String number;

    private String street;

    private String street2;

    @ManyToOne
    private PostalCode postalCode;

    @ManyToOne
    private Country country;

    @ManyToOne
    private Region region;

    @ManyToOne
    private County county;

}