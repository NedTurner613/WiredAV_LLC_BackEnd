package com.wiredav.app.dtos.appointmentDTOs;

public record RequestConsultClientDTO(
        String firstName,
        String lastName,
        String email,
        String phoneNumber
) {
}
