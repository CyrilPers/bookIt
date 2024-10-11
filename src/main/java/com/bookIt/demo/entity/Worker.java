package com.bookIt.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Worker extends User {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_company", nullable = false)
    private Company company;

    @ManyToMany
    private List<Role> roles;

    @OneToMany(mappedBy = "worker")
    private List<Planning> plannings;

    public Worker(Integer id, String firstName, String lastName, Boolean enabled, String email, String password, String phoneNumber, LocalDateTime creationDate, Address address, Company company, List<Role> roles, List<Planning> plannings) {
        super(id, firstName, lastName, enabled, email, password, phoneNumber, creationDate, address);
        this.company = company;
        this.roles = roles;
        this.plannings = plannings;
    }

    public Worker(Company company, List<Role> roles, List<Planning> plannings) {
        this.company = company;
        this.roles = roles;
        this.plannings = plannings;
    }

    public Worker() {

    }
}