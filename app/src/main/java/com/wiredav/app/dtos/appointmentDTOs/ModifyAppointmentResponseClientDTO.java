package com.wiredav.app.dtos.appointmentDTOs;

public record ModifyAppointmentResponseClientDTO(
        Long clientId,
        String firstName,
        String lastName
) {
}
