package com.appointments.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "appointment_status")
public class AppointmentStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointment_status_id")
    private Long appointmentStatusId;

    @Column(name = "appointment_status")
    private String appointmentStatus;

    public Long getAppointmentStatusId() {
        return appointmentStatusId;
    }

    public void setAppointmentStatusId(Long appointmentStatusId) {
        this.appointmentStatusId = appointmentStatusId;
    }

    public String getAppointmentStatus() {
        return appointmentStatus;
    }

    public void setAppointmentStatus(String appointmentStatus) {
        this.appointmentStatus = appointmentStatus;
    }
}
