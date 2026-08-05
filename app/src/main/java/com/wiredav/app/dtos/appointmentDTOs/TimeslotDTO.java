package com.wiredav.app.dtos.appointmentDTOs;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TimeslotDTO {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
