package com.wiredav.app.dtos.appointmentDTOs;

public record MakeAppointmentResponsePersonnelDTO(
    Long personnelId,
    String firstName,
    String lastName
) {
}
