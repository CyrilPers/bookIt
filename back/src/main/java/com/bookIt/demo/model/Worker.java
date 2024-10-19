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

    @OneToMany(mappedBy = "worker", fetch = FetchType.EAGER)
    private List<WorkerCompany> workerCompany;

    public Worker(String professionnalPhoneNumber) {
        this.professionnalPhoneNumber = professionnalPhoneNumber;
    }

    public Worker() {}

    public List<WorkerCompany> getWorkerCompany() {
        return workerCompany;
    }

    public void setWorkerCompany(List<WorkerCompany> workerCompany) {
        this.workerCompany = workerCompany;
    }

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