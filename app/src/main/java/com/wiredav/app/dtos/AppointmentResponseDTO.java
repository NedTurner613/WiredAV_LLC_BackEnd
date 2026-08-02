package com.wiredav.app.dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import com.wiredav.app.enums.ApptStatus;
import com.wiredav.app.enums.ApptType;
import com.wiredav.app.dtos.ClientInfoDTO;
import com.wiredav.app.dtos.PersonnelInfoDTO;
import com.wiredav.app.dtos.TimeslotDTO;

import java.sql.Time;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentResponseDTO {
    private Long apptId;
    private ApptStatus status;
    private ClientInfoDTO clientInfo;
    private PersonnelInfoDTO personnelInfo;
    private TimeslotDTO timeslot;
    private ApptType type;
    private Time createdAt;
    private Time updatedAt;

//    constructor for creating the DTO without createdAt and updatedAt values
    public AppointmentResponseDTO(Long apptId, ApptStatus status, ClientInfoDTO clientInfo, PersonnelInfoDTO personnelInfo, TimeslotDTO timeslot, ApptType type){
        this.apptId = apptId;
        this.status = status;
        this.clientInfo = clientInfo;
        this.personnelInfo = personnelInfo;
        this.timeslot = timeslot;
        this.type = type;
    }
}
