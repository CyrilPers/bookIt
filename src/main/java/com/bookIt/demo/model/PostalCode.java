package com.bookIt.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class PostalCode {
    @Id
    private String code;

    public PostalCode() {
    }

    public PostalCode(String number) {
        this.code = number;
    }
}