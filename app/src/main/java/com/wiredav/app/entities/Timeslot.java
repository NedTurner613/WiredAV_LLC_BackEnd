package com.wiredav.app.entities;

import jakarta.persistence.*;

import java.sql.Time;
import java.time.LocalDateTime;

@Entity
@Table(name = "timeslot")
public class Timeslot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "timeslot_id", nullable = false)
    private long timeslotId;

    @Column(name = "start_time", nullable = false)
    private LocalDateTime startTime;

    @Column(name = "end_time", nullable = false)
    private LocalDateTime endTime;

    @OneToOne(mappedBy = "timeslot")
    private Appointments appointments;

    public Timeslot(LocalDateTime startTime, LocalDateTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Timeslot() {}

    public void setTimeslotId(long timeslotId) {
        this.timeslotId = timeslotId;
    }

    public long getTimeslotId() {
        return timeslotId;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setAppointments(Appointments appointments) {
        this.appointments = appointments;
    }

    public Appointments getAppointments() {
        return appointments;
    }
}
