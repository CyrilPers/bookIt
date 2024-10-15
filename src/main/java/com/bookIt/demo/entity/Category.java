package com.bookIt.demo.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Builder
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String label;

    @ManyToMany
    private List<Company> companies;

    public Category() {
    }

    public Category(Integer id, String label, List<Company> companies) {
        this.id = id;
        this.label = label;
        this.companies = companies;
    }
}