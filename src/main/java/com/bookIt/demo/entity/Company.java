package com.bookIt.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
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

    @ManyToMany
    private List<Category> categories;

    private String description;

    private Integer siret;

    private Integer textMessageBalance;

    private String adminLink;

    @OneToOne
    private Address address;

    private LocalDateTime creation;

}