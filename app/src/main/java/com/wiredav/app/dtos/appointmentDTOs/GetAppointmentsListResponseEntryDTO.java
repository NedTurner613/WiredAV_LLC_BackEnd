package com.wiredav.app.dtos.appointmentDTOs;

public record GetAppointmentsListResponseEntryDTO(
    Long apptId,
    Integer status,
    GetAppointmentsListResponseEntryClientDTO clientInfo,
    GetAppointmentsListResponseEntryPersonnelDTO personnelInfo,
    TimeslotWithIdDTO timeslot,
    Integer apptType
) {
}
