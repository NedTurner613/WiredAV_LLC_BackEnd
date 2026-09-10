package com.wiredav.app.dtos.personnelDTOs;



public record RegisterTechnicianRequestDTO(
        String firstName,
        String lastName,
        String email,
        Integer role
) {
}
