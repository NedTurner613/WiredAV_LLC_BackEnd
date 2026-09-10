package com.wiredav.app.dtos.appointmentDTOs;

import java.util.Set;

public record GetAppointmentsListResponseDTO(
    Set<GetAppointmentsListResponseEntryDTO> appointments
) {
}
