package com.wiredav.app.dtos.personnelDTOs;


public record LoginResponseDTO(
        String token,
        Long userId
) {
}
