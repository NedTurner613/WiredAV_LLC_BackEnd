package com.wiredav.app.dtos.personnelDTOs;


public record AddTechnicianResponseDTO(
        Long personnelId,
        String firstName,
        String lastName,
        String email,
        Integer role) {
}
