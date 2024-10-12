package com.bookIt.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Worker extends User {

    @Column(unique = true)
    private String professionnalPhoneNumber;

    @OneToMany
    private List<Planning> plannings = new ArrayList<>();

    public Worker(String professionnalPhoneNumber, List<Planning> plannings) {
        this.professionnalPhoneNumber = professionnalPhoneNumber;
        this.plannings = plannings;
    }

    public Worker(Integer id, String firstName, String lastName, Boolean enabled, String email, String password, String phoneNumber, LocalDateTime creationDate, Address address, String professionnalPhoneNumber, List<Planning> plannings) {
        super(id, firstName, lastName, enabled, email, password, phoneNumber, creationDate, address);
        this.professionnalPhoneNumber = professionnalPhoneNumber;
        this.plannings = plannings;
    }

    public Worker() {

    }
}