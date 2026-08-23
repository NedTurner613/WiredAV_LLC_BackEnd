package com.wiredav.app.dtos.appointmentDTOs;

public record ModifyAppointmentRequestDTO(
    Long apptId,
    Integer status,
    TimeslotDTO timeslot,
    Long clientId,
    Long personnelId,
    Integer apptType
    ) {}
