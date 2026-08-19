package com.wiredav.app.dtos.clientDTOs;

public record AddClientRequestDTO(
    Long id,
    String firstName,
    String lastName,
    String email,
    String phoneNumber
){}


