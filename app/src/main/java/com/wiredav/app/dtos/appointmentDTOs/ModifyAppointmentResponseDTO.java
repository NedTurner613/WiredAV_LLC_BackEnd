package com.wiredav.app.dtos.appointmentDTOs;

import com.wiredav.app.dtos.personnelDTOs.PersonnelInfoDTO;

import java.time.LocalDateTime;

public record ModifyAppointmentResponseDTO(
    Long apptId,
    Integer status,
    ModifyAppointmentResponseClientDTO clientInfo,
    PersonnelInfoDTO personnelInfo,
    TimeslotWithIdDTO timeslot,
    Integer apptType,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
    ) {}


