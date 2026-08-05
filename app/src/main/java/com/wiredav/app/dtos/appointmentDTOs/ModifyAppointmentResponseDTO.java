package com.wiredav.app.dtos.appointmentDTOs;

import com.wiredav.app.dtos.clientDTOs.GetClientResponseDTO;
import com.wiredav.app.dtos.personnelDTOs.PersonnelInfoDTO;
import com.wiredav.app.enums.ApptStatus;
import com.wiredav.app.enums.ApptType;
import com.wiredav.app.enums.PersonnelRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ModifyAppointmentResponseDTO {
    private Long apptId;
    private ApptStatus status;
    private GetClientResponseDTO clientInfo;
    private PersonnelInfoDTO personnelInfo;
    private TimeslotWIthIdDTO timeslot;
    private ApptType apptType;
    private Time createdAt;
    private Time updatedAt;
}

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class ModifyAppointmentResponsePersonnelDTO{
    private Long personnelId;
    private String firstName;
    private String lastName;
    private PersonnelRole role;
}

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class ModifyAppointmentResponseClientDTO{
    private Long clientId;
    private String firstName;
    private String lastName;
}

