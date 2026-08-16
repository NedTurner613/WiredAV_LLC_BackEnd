package com.wiredav.app.dtos.personnelDTOs;



/**
 * DTO used for Update Personnel Request and Response as well as GetPersonnel Response
 */
public record PersonnelInfoDTO(
        Long personnelId,
        String firstName,
        String lastName,
        String email,
        Integer role
) {
}
