package com.wiredav.app.dtos.personnelDTOs;



public record RegisterUserRequestDTO(
        String firstName,
        String lastName,
        String email,
        String password
) {
}
