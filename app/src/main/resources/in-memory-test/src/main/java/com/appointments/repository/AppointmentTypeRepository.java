package com.appointments.repository;

import com.appointments.entity.AppointmentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentTypeRepository extends JpaRepository<AppointmentType, Long> {
}
