package com.wiredav.app.dtos.appointmentDTOs;

import com.wiredav.app.dtos.clientDTOs.AddClientRequestDTO;

public record RequestConsultRequestDTO(
    AddClientRequestDTO clientInfo,
    TimeslotDTO timeslot
) {}
