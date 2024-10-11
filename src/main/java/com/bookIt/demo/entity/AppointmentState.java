package com.bookIt.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "appointment_state")
public class AppointmentState {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String label;

    @OneToMany(mappedBy = "appointmentState")
    private List<Appointment> appointments = new ArrayList<>();

}