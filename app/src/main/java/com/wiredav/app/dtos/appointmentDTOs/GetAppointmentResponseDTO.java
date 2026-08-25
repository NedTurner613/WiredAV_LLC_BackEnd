package com.wiredav.app.dtos.appointmentDTOs;

import java.sql.Time;
import java.time.LocalDateTime;

public record GetAppointmentResponseDTO(
    Long apptId,
    Integer status,
    GetAppointmentResponsePersonnelDTO personnelInfo,
    GetAppointmentResponseClientDTO clientInfo,
    TimeslotWithIdDTO timeslot,
    Integer apptType,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
    ) {}


