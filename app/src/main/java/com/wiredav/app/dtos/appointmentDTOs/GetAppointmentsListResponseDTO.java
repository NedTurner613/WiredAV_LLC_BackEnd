package com.wiredav.app.dtos.appointmentDTOs;

import java.util.Set;

public record GetAppointmentsListResponseDTO(
    Set<GetAppointmentsListResponseEntryDTO> appointments
) {
    public GetAppointmentsListResponseDTO(Set<GetAppointmentsListResponseEntryDTO> appointments) {
        this.appointments = appointments;
    }
}
