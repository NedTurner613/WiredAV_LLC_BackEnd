package com.wiredav.app.dtos.personnelDTOs;

import com.wiredav.app.enums.PersonnelRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public record AddPersonnelResponseDTO(
        Long personnelId,
        String firstName,
        String lastName,
        String email,
        PersonnelRole role) {

}
