package com.bookIt.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(cascade = CascadeType.PERSIST)
    private UserAccount user;

    @Column(unique = true)
    private String professionnalPhoneNumber;

    public Worker(String professionnalPhoneNumber) {
        this.professionnalPhoneNumber = professionnalPhoneNumber;
    }

    public Worker() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserAccount getUser() {
        return user;
    }

    public void setUser(UserAccount user) {
        this.user = user;
    }

    public String getProfessionnalPhoneNumber() {
        return professionnalPhoneNumber;
    }

    public void setProfessionnalPhoneNumber(String professionnalPhoneNumber) {
        this.professionnalPhoneNumber = professionnalPhoneNumber;
    }
}