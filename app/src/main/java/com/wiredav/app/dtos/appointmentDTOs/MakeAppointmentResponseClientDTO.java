package com.wiredav.app.dtos.appointmentDTOs;

public record MakeAppointmentResponseClientDTO(
    Long clientId,
    String firstName,
    String lastName,
    String phoneNumber,
    String email
) {
}
