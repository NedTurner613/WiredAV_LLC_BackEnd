package com.wiredav.app.dtos.appointmentDTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TimeslotWIthIdDTO {
    private Long timeslotId;
    private String startTime;
    private String endTime;
}
