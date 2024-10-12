package com.bookIt.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Customer extends User {

    private Boolean advertising = false;

    @OneToMany
    private List<Appointement> appointements = new ArrayList<>();

    public Customer() {}

    public Customer(Worker worker) {
        super(worker.getId(), worker.getFirstName(), worker.getLastName(), worker.getEnabled(), worker.getEmail(), worker.getPassword(), worker.getPhoneNumber(), worker.getCreationDate(), worker.getAddress());
    }

    public Boolean getAdvertising() {
        return advertising;
    }

    public void setAdvertising(Boolean advertising) {
        this.advertising = advertising;
    }

    public Customer(Integer id, String firstName, String lastName, Boolean enabled, String email, String password, String phoneNumber, LocalDateTime creationDate, Address address, Boolean advertising) {
        super(id, firstName, lastName, enabled, email, password, phoneNumber, creationDate, address);
        this.advertising = advertising;
    }
}