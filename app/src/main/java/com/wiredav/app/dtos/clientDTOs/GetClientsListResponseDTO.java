package com.wiredav.app.dtos.clientDTOs;

import java.util.List;

public record GetClientsListResponseDTO (
     List<GetClientResponseDTO> clients
) {

    }