package com.wiredav.app.dtos.clientDTOs;


public record AddClientResponseDTO(
        Long clientId,
        String firstName,
        String lastName,
        String email,
        String phoneNumber
) {
}