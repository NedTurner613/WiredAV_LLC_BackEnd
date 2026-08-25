package com.wiredav.app.dtos.appointmentDTOs;

public record GetAppointmentResponsePersonnelDTO(
    Long personnelId,
    String firstName,
    String lastName,
    Integer role
) { }
