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
public class ModifyAppointmentRequestDTO {
    private Long apptId;
    private ApptStatus status;
    private TimeslotDTO timeslot;
    private Long clientId;
    private Long personnelId;
    private ApptType apptType;
}
