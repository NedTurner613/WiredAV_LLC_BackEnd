package com.wiredav.app.dtos.personnelDTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public record LoginResponseDTO(
        String token,
        Long userId
) {
}
