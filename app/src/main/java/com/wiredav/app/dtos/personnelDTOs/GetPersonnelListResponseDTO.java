package com.wiredav.app.dtos.personnelDTOs;


public record GetPersonnelListResponseDTO(
        Long personnelId,
        String firstName,
        String lastName,
        Integer role
) {
}