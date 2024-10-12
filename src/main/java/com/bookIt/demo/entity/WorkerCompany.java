package com.bookIt.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class WorkerCompany{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Worker worker;

    @ManyToOne
    private Company company;

    @ManyToMany
    private List<Role> roles = new ArrayList<>();

    @ManyToMany
    private List<Appointement> appointements = new ArrayList<>();

    @ManyToMany
    private List<Service> services = new ArrayList<>();
}
