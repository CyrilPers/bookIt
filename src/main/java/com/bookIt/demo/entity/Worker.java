package com.bookIt.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Worker extends User {

    @OneToMany
    private List<Planning> planning;

    public Worker(Integer id, String firstName, String lastName, Boolean enabled, String email, String password, String phoneNumber, LocalDateTime creationDate, Address address, List<Planning> planning) {
        super(id, firstName, lastName, enabled, email, password, phoneNumber, creationDate, address);
        this.planning = planning;
    }

    public Worker() {}
}