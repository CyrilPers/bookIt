package com.bookIt.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    private UserAccount user;

     @OneToMany(mappedBy = "worker")
     private List<WorkerCompany> workerCompanies;

    @Column(unique = true)
    private String professionnalPhoneNumber;

    public Worker(String professionnalPhoneNumber) {
        this.professionnalPhoneNumber = professionnalPhoneNumber;
    }

    public Worker() {}

}