package com.wiredav.app.dtos.personnelDTOs;

import com.wiredav.app.enums.PersonnelRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddPersonnelResponseDTO {
    private Long personnelId;
    private String firstName;
    private String lastName;
    private String email;
    private PersonnelRole role;
}
