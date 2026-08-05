package com.wiredav.app.dtos.appointmentDTOs;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import com.wiredav.app.enums.ApptStatus;
import com.wiredav.app.enums.ApptType;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MakeAppointmentResponseDTO {
    private Long apptId;
    private ApptStatus status;
    private MakeAppointmentResponsePersonnelDTO personnelInfo;
    private MakeAppointmentResponseClientDTO clientInfo;
    private TimeslotWIthIdDTO timeslot;
    private ApptType apptType;
}

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class MakeAppointmentResponsePersonnelDTO{
    private Long personnelId;
    private String firstName;
    private String lastName;
}

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class MakeAppointmentResponseClientDTO{
    private Long clientId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
}
