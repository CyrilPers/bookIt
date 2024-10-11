package com.bookIt.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Entity
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Short duration;

    private String description;

    private String name;

    private BigDecimal price;

    @OneToMany
    private List<Appointement> appointements;

    @ManyToOne
    private Category category;
}