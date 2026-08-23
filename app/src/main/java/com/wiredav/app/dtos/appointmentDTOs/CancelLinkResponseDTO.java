package com.wiredav.app.dtos.appointmentDTOs;

public record CancelLinkResponseDTO(
    Long apptId,
    Integer status,
    CancelLinkResponseClientDTO clientInfo,
    TimeslotDTO timeslot,
    Integer apptType
    ) {}



