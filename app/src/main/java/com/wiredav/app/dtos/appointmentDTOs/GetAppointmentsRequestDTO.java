package com.wiredav.app.dtos.appointmentDTOs;

import java.util.Set;

public record GetAppointmentsRequestDTO(
    Set<Long> personnelIds,
    TimeslotDTO timeFrame
) {
}
