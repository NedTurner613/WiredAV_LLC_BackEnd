package com.wiredav.app.dtos.appointmentDTOs;

public record ModifyAppointmentResponsePersonnelDTO(
        Long personnelId,
        String firstName,
        String lastName,
        Integer role
) {
}
