package com.bookIt.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
public class Planning {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Instant dateStart;

    private Instant dateEnd;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Company company;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Worker worker;
}