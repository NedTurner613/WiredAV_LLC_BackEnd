package com.wiredav.app.repositories;

import com.wiredav.app.entities.Appointments;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;

public interface AppointmentsRepository extends CrudRepository<Appointments, Long> {

    @Query("SELECT a FROM Appointments a WHERE a.personnel.personnelId IN :personnelIds AND a.timeslot.startTime >= :start AND a.timeslot.startTime <= :end")
    Optional<Set<Appointments>> findAppointmentsByPersonnelAndTimeframe(Set<Long> personnelIds, LocalDateTime start, LocalDateTime end);
}
