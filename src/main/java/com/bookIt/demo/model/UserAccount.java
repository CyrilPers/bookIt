package com.bookIt.demo.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName;

    private String lastName;

    private Boolean enabled = false;

    @Email(message = "EMAIL_FORMAT_ERROR")
    @Column(unique = true)
    private String email;

    private String password;

    @Column(unique = true)
    private String phoneNumber;

    private LocalDateTime creationDate;

    @OneToOne
    private Customer customer;

    @OneToOne
    private Worker worker;

    @OneToOne(orphanRemoval = true, cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
    @JoinColumn(name = "address_id", foreignKey = @ForeignKey(name = "FK_USER_ADDRESS"))
    private Address address;

    public UserAccount() {}

    public UserAccount(Integer id, String firstName, String lastName, Boolean enabled, String email, String password, String phoneNumber, LocalDateTime creationDate, Address address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.enabled = enabled;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.creationDate = creationDate;
        this.address = address;
        this.creationDate = LocalDateTime.now();
    }
}