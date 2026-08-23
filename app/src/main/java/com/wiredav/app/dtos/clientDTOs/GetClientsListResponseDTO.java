package com.wiredav.app.dtos.clientDTOs;

import java.util.List;

public record GetClientsListResponseDTO (
     List<GetClientsListEntryResponseDTO> clients
) {
    public record GetClientsListEntryResponseDTO(
            Long clientId,
            String firstName,
            String lastName
    ) {
    }
}