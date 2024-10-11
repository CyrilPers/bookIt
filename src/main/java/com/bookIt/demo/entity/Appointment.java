package com.bookIt.demo.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDateTime dateStart;

    private LocalDateTime dateEnd;

    @ManyToMany
    private List<User> user;

    @ManyToOne(optional = false)
    private AppointmentState appointmentState;
}