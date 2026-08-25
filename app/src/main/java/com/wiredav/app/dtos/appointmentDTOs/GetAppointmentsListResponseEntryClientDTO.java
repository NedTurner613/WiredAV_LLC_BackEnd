package com.wiredav.app.dtos.appointmentDTOs;

public record GetAppointmentsListResponseEntryClientDTO(
        Long clientId,
        String firstName,
        String lastName
) {
}
