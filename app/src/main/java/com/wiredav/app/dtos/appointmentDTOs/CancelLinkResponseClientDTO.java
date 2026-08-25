package com.wiredav.app.dtos.appointmentDTOs;

public record CancelLinkResponseClientDTO(
    Long clientId,
    String firstName,
    String lastName,
    String phoneNumber,
    String email
) {
}
