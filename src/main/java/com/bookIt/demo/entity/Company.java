package com.bookIt.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Category> categories = new ArrayList<>();

    private String description;

    @Column(unique = true)
    private Integer siret;

    private Integer smsBalance;

    private String adminLink;

    @OneToOne
    private Address address;

    private LocalDateTime creation;

    @OneToMany(mappedBy = "company", fetch = FetchType.EAGER)
    private List<Service> services = new ArrayList<>();

    @OneToMany(mappedBy = "company", fetch = FetchType.EAGER)
    private List<WorkerCompany> workerCompanies  = new ArrayList<>();

    public Company(String name, String description) {
        this.name = name;
        this.description = description;
    }
}