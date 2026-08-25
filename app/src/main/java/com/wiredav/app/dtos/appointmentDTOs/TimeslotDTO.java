package com.wiredav.app.dtos.appointmentDTOs;

import java.time.LocalDateTime;

public record TimeslotDTO(
        LocalDateTime startTime,
        LocalDateTime endTime
) {
}
