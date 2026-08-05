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
/**
 * DTO used for Update Personnel Request and Response as well as GetPersonnel Response
 */
public class PersonnelInfoDTO {
    private Long personnelId;
    private String firstName;
    private String lastName;
    private String email;
    private PersonnelRole role;
}
