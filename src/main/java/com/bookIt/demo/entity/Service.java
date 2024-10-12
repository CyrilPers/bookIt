package com.bookIt.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

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

    @ManyToOne
    private Category category;

    @ManyToOne
    private Company company;
}