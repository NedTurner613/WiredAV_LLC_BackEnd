package com.wiredav.app.dtos.personnelDTOs;



public record AddPersonnelRequestDTO(
        String firstName,
        String lastName,
        String email,
        Integer role
) {
}
