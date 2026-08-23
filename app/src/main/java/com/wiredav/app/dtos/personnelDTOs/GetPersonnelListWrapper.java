package com.wiredav.app.dtos.personnelDTOs;

import java.util.Set;

public record GetPersonnelListWrapper(
        Set<GetPersonnelListResponseDTO> personnelList
) {
}
