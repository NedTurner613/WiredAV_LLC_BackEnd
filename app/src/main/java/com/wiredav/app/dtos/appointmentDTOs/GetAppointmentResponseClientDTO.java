package com.wiredav.app.dtos.appointmentDTOs;

public record GetAppointmentResponseClientDTO(
    Long clientId,
    String firstName,
    String lastName
) {
}
