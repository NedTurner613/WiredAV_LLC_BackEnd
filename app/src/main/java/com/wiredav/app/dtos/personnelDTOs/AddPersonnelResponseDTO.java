package com.wiredav.app.dtos.personnelDTOs;


public record AddPersonnelResponseDTO(
        Long personnelId,
        String firstName,
        String lastName,
        String email,
        Integer role) {
}
