package com.wiredav.app.dtos.clientDTOs;

import com.wiredav.app.entities.Clients;

import java.util.List;

public record GetClientsListResponseDTO (
     List<Clients> clients
) {

    }