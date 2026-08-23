package com.wiredav.app.repositories;

import com.wiredav.app.entities.Timeslot;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public interface TimeslotRepository extends CrudRepository<Timeslot, Long> {

    @Query("SELECT t FROM Timeslot t WHERE t.appointments.appointmentId = :id")
    Timeslot findByAppointmentsId(Long id);

    @Query("SELECT t FROM Timeslot t WHERE t.startTime = :startTime")
    List<Timeslot> findAllByStartTime(LocalDateTime startTime);
}
