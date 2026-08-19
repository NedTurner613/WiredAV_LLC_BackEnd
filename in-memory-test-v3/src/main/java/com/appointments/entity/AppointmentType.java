package com.appointments.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "appointment_type")
public class AppointmentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointmentTypeID")
    private Long appointmentTypeID;

    @Column(name = "appointmentType")
    private String appointmentType;

    public Long getAppointmentTypeID() {
        return appointmentTypeID;
    }

    public void setAppointmentTypeID(Long appointmentTypeID) {
        this.appointmentTypeID = appointmentTypeID;
    }

    public String getAppointmentType() {
        return appointmentType;
    }

    public void setAppointmentType(String appointmentType) {
        this.appointmentType = appointmentType;
    }
}
