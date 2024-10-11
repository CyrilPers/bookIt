package com.bookIt.demo.entity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String firstName;

    private String lastName;

    private Boolean enabled = false;

    private String email;

    private String password;

    private String phoneNumber;

    private LocalDateTime creationDate;

    @OneToOne(orphanRemoval = true, cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
    @JoinColumn(name = "address_id", foreignKey = @ForeignKey(name = "FK_USER_ADDRESS"))
    private Address address;

    public User() {}

    public User(Integer id, String firstName, String lastName, Boolean enabled, String email, String password, String phoneNumber, LocalDateTime creationDate, Address address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.enabled = enabled;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.creationDate = creationDate;
        this.address = address;
    }
}