package com.wiredav.app.entities;

import com.wiredav.app.dtos.appointmentDTOs.TimeslotDTO;
import com.wiredav.app.dtos.appointmentDTOs.TimeslotWithIdDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "timeslot")
@Getter
@Setter
@AllArgsConstructor
@Builder
public class Timeslot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "timeslotId", nullable = false)
    private long timeslotId;

    @Column(name = "startTime", nullable = false)
    private LocalDateTime startTime;

    @Column(name = "endTime", nullable = false)
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

    public TimeslotDTO toTimeslotDTO() {
        return new TimeslotDTO(
                this.startTime,
                this.endTime
        );
    }

    public TimeslotWithIdDTO toTimeslotWithIdDTO() {
        return new TimeslotWithIdDTO(
                this.timeslotId,
                this.startTime,
                this.endTime
        );
    }

}
