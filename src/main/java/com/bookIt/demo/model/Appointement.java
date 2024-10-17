package com.bookIt.demo.model;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Appointement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDateTime dateStart;

    private LocalDateTime dateEnd;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private Performance performance;

    @ManyToOne
    private AppointmentState appointmentState;

    @ManyToOne(fetch = FetchType.EAGER)
    private WorkerCompany workerCompany;

    @ManyToOne(fetch = FetchType.EAGER)
    private Customer customer;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDateStart() {
        return dateStart;
    }

    public void setDateStart(LocalDateTime dateStart) {
        this.dateStart = dateStart;
    }

    public LocalDateTime getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(LocalDateTime dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Performance getPerformance() {
        return performance;
    }

    public void setPerformance(Performance performance) {
        this.performance = performance;
    }

    public AppointmentState getAppointmentState() {
        return appointmentState;
    }

    public void setAppointmentState(AppointmentState appointmentState) {
        this.appointmentState = appointmentState;
    }

    public WorkerCompany getWorkerCompany() {
        return workerCompany;
    }

    public void setWorkerCompany(WorkerCompany workerCompany) {
        this.workerCompany = workerCompany;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}