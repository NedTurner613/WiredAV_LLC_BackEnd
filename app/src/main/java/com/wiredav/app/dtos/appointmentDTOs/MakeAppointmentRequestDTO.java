package com.wiredav.app.dtos.appointmentDTOs;

import com.wiredav.app.enums.ApptStatus;
import com.wiredav.app.enums.ApptType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MakeAppointmentRequestDTO {
    private Long personnelId;
    private TimeslotDTO timeslot;
    private ApptStatus status;
    private Long clientId;
    private ApptType apptType;
}
