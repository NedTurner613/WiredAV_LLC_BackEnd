package com.wiredav.app.dtos.clientDTOs;

public record AddClientRequestDTO(
    String firstName,
    String lastName,
    String email,
    String phoneNumber
){}


