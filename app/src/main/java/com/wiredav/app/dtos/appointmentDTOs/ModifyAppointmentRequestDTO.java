package com.wiredav.app.dtos.appointmentDTOs;

import java.time.LocalDateTime;

public record ModifyAppointmentRequestDTO(
    Long apptId,
    Integer status,
    TimeslotDTO timeslot,
    Long clientId,
    Long personnelId,
    Integer apptType,
    LocalDateTime createdAt
    ) {}
