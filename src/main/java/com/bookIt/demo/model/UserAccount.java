package com.bookIt.demo.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

import java.time.LocalDateTime;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}