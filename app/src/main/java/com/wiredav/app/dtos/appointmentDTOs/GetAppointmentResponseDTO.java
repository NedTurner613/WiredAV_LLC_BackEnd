package com.wiredav.app.dtos.appointmentDTOs;

import com.wiredav.app.enums.PersonnelRole;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import com.wiredav.app.enums.ApptStatus;
import com.wiredav.app.enums.ApptType;

import java.sql.Time;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetAppointmentResponseDTO {
    private Long apptId;
    private ApptStatus status;
    private GetAppointmentResponsePersonnelDTO personnelInfo;
    private GetAppointmentResponseClientDTO clientInfo;
    private TimeslotWIthIdDTO timeslot;
    private ApptType apptType;
    private Time createdAt;
    private Time updatedAt;
}

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class GetAppointmentResponsePersonnelDTO{
    private Long personnelId;
    private String firstName;
    private String lastName;
    private PersonnelRole role;
}

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class GetAppointmentResponseClientDTO{
    private Long clientId;
    private String firstName;
    private String lastName;
}

