package com.wiredav.app.dtos.appointmentDTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetAppointmentsRequestDTO {
    private List<Long> personnelIds;
    private TimeslotDTO timeFrame;
}
