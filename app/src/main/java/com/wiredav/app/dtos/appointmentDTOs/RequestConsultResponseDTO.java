package com.wiredav.app.dtos.appointmentDTOs;

public record RequestConsultResponseDTO(
        RequestConsultClientDTO clientInfo,
        TimeslotDTO timeslot
) {
}
