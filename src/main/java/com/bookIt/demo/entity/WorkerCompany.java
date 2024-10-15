package com.bookIt.demo.entity;

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

    @ManyToOne
    private Worker worker;

    @ManyToOne
    private Company company;

    @ManyToMany
    private List<Role> roles = new ArrayList<>();

    @ManyToMany
    private List<Appointement> appointements = new ArrayList<>();

    @OneToMany
    private List<Planning> plannings = new ArrayList<>();

    @ManyToMany
    private List<Service> services = new ArrayList<>();

    public WorkerCompany(Worker worker, Company company) {
        this.worker = worker;
        this.company = company;
    }

}
