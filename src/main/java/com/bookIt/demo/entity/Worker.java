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
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    private User user;

    @Column(unique = true)
    private String professionnalPhoneNumber;

    public Worker(String professionnalPhoneNumber) {
        this.professionnalPhoneNumber = professionnalPhoneNumber;
    }

    public Worker() {}

}