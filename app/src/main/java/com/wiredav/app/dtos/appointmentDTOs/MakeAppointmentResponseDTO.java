package com.wiredav.app.dtos.appointmentDTOs;

public record MakeAppointmentResponseDTO(
    Long apptId,
    Integer status,
    MakeAppointmentResponsePersonnelDTO personnelInfo,
    MakeAppointmentResponseClientDTO clientInfo,
    TimeslotWithIdDTO timeslot,
    Integer apptType
) {}