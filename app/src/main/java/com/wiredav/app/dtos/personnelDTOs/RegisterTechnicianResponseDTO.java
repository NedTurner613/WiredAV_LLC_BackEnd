package com.wiredav.app.dtos.personnelDTOs;


public record RegisterTechnicianResponseDTO(
        Long personnelId,
        String firstName,
        String lastName,
        String email,
        Integer role) {
}
