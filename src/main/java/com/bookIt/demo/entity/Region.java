package com.bookIt.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "region")
public class Region {
    @Id
    @Column(name = "insee_region", nullable = false, length = 50)
    private String inseeRegion;
}