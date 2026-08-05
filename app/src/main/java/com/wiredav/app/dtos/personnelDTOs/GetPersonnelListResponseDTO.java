package com.wiredav.app.dtos.personnelDTOs;

import com.wiredav.app.enums.PersonnelRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetPersonnelListResponseDTO {
    private List<PersonnelInfoListEntryDTO> personnelList;
}

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class PersonnelInfoListEntryDTO{
    private Long personnelId;
    private String firstName;
    private String lastName;
    private PersonnelRole role;
}
