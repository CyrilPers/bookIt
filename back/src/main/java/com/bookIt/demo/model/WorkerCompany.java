package com.bookIt.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WorkerCompany{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Worker worker;

    @ManyToOne
    private Company company;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<Role> roles = new ArrayList<>();

    @ManyToMany
    private List<Appointement> appointements = new ArrayList<>();

    @OneToMany
    private List<Planning> plannings = new ArrayList<>();

    @ManyToMany
    private List<Treatment> treatments = new ArrayList<>();

    public WorkerCompany(Worker worker, Company company) {
        this.worker = worker;
        this.company = company;
    }

}
