package com.appointments.repository;

import com.appointments.entity.AppointmentStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentStatusRepository extends JpaRepository<AppointmentStatus, Integer> {
}
