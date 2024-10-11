package com.bookIt.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "postal_code")
public class PostalCode {
    @Id
    private String code;

    public PostalCode() {
    }

    public PostalCode(String number) {
        this.code = number;
    }
}