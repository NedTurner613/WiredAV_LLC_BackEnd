package com.wiredav.app.repositories;

import com.wiredav.app.entities.Appointments;
import org.springframework.data.repository.CrudRepository;

public interface AppointmentsRepository extends CrudRepository<Appointments, Long> {
}
