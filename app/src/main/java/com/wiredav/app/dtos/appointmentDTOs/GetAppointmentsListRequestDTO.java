package com.wiredav.app.dtos.appointmentDTOs;

import java.util.Set;

public record GetAppointmentsListRequestDTO(
    Set<Long> personnelIds,
    TimeslotDTO timeFrame
) {
}
