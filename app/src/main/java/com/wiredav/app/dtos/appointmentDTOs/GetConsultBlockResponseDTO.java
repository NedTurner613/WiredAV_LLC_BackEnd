package com.wiredav.app.dtos.appointmentDTOs;

import java.util.List;

public record GetConsultBlockResponseDTO(
    List<TimeslotDTO> timeslots
) {
    public GetConsultBlockResponseDTO(List<TimeslotDTO> timeslots) {
        this.timeslots = timeslots;
    }
}
