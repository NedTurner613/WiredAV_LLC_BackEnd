package com.wiredav.app.dtos.appointmentDTOs;

import com.wiredav.app.dtos.clientDTOs.GetClientResponseDTO;
import com.wiredav.app.dtos.personnelDTOs.PersonnelInfoDTO;

public record GetAppointmentsListResponseEntryDTO(
    Long apptId,
    Integer status,
    GetClientResponseDTO clientInfo,
    PersonnelInfoDTO personnelInfo,
    TimeslotDTO timeslot,
    Integer apptType
) {
}
