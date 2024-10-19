package com.bookIt.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Treatment {
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