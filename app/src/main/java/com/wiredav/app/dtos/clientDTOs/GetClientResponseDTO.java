package com.wiredav.app.dtos.clientDTOs;

public record GetClientResponseDTO(
        Long clientId,
        String firstName,
        String lastName,
        String email,
        String phoneNumber
) {
}