package com.bookIt.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Boolean advertising = false;

    @OneToOne
    private UserAccount user;

    @OneToMany
    private List<Appointement> appointements = new ArrayList<>();

    public Customer() {}
}