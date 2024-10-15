package com.bookIt.demo.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Appointement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDateTime dateStart;

    private LocalDateTime dateEnd;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private Service service;

    @ManyToOne(optional = false)
    private AppointmentState appointmentState;

    @ManyToOne
    private WorkerCompany workerCompany;

    @ManyToOne
    private Customer customers;
}