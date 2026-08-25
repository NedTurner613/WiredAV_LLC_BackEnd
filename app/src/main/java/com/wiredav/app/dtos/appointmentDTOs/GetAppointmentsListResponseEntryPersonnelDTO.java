package com.wiredav.app.dtos.appointmentDTOs;

public record GetAppointmentsListResponseEntryPersonnelDTO(
        Long personnelId,
        String firstName,
        String lastName
) {
}
