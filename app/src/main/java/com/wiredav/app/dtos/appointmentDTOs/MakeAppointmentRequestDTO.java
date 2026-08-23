package com.wiredav.app.dtos.appointmentDTOs;

public record MakeAppointmentRequestDTO(
    Long personnelId,
    TimeslotDTO timeslot,
    Integer status,
    Long clientId,
    Integer apptType
) {}
