package com.bookIt.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class County {
    @Id
    private Integer id;

    private String label;

    private Integer number;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Region inseeRegion;
}