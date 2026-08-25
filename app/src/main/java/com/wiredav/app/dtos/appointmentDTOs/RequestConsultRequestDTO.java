package com.wiredav.app.dtos.appointmentDTOs;

public record RequestConsultRequestDTO(
    RequestConsultClientDTO clientInfo,
    TimeslotDTO timeslot
) {}
