package com.wiredav.app.dtos.clientDTOs;

import com.wiredav.app.entities.Clients;

public record GetClientResponseDTO(
        Long clientId,
        String firstName,
        String lastName,
        String email,
        String phoneNumber
) {
    public GetClientResponseDTO(Clients clients) {
        this(
                clients.getClientId(),
                clients.getFirstName(),
                clients.getLastName(),
                clients.getEmailAddress(),
                clients.getPhoneNumber()
        );
    }
}