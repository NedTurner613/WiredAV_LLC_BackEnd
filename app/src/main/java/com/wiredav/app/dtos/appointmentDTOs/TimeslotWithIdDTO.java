package com.wiredav.app.dtos.appointmentDTOs;

import java.time.LocalDateTime;

public record TimeslotWithIdDTO(
    Long timeslotId,
    LocalDateTime startTime,
    LocalDateTime endTime
) {}
