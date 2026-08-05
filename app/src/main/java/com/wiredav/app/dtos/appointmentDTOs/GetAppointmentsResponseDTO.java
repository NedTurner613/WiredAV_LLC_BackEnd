package com.wiredav.app.dtos.appointmentDTOs;

import com.wiredav.app.dtos.clientDTOs.GetClientResponseDTO;
import com.wiredav.app.dtos.personnelDTOs.PersonnelInfoDTO;
import com.wiredav.app.enums.ApptStatus;
import com.wiredav.app.enums.ApptType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class GetAppointmentsResponseDTO {
}

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class GetAppointmentsResponseEntryDTO {
    private Long apptId;
    private ApptStatus status;
    private GetClientResponseDTO clientInfo;
    private PersonnelInfoDTO personnelInfo;
    private TimeslotDTO timeslot;
    private ApptType apptType;
}