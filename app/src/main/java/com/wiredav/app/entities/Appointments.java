package com.wiredav.app.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "appointments")
public class Appointments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointment_id", nullable = false)
    private long appointmentId;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Clients client;

    @Column(name = "status", nullable = false)
    private Integer status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "timeslot_id", referencedColumnName = "timeslot_id")
    private Timeslot timeslot;

    @ManyToOne
    @JoinColumn(name = "personnel_id", nullable = true)
    private Personnel personnel;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = true)
    private LocalDateTime updatedAt;

    @Column(name = "appointment_type", nullable = false)
    private Integer appointmentType;

    public Appointments(Integer status, Timeslot timeslotId, Integer appointmentType, Personnel personnel, Clients client) {
        this.status = status;
        this.timeslot = timeslotId;
        this.appointmentType = appointmentType;
        this.personnel = personnel;
        this.client = client;
        //Create entity functions to set updatedAt and createdAt values
    }

    public Appointments() {}

    public void setAppointmentId(long appointmentId) {
        this.appointmentId = appointmentId;
    }

    public long getAppointmentId() {
        return appointmentId;
    }

    public void setClient(Clients client) {
        this.client = client;
    }

    public Clients getClient() {
        return client;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }

    public void setTimeslot(Timeslot timeslot) {
        this.timeslot = timeslot;
    }

    public Timeslot getTimeslot() {
        return timeslot;
    }

    public void setPersonnel(Personnel personnel) {
        this.personnel = personnel;
    }

    public Personnel getPersonnel() {
        return personnel;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setAppointmentType(Integer appointmentType) {
        this.appointmentType = appointmentType;
    }

    public Integer getAppointmentType() {
        return appointmentType;
    }
}
