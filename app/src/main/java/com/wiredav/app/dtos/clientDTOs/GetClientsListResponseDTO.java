package com.wiredav.app.dtos.clientDTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetClientsListResponseDTO {
    private List<GetClientsListEntryResponseDTO> clients;
}
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class GetClientsListEntryResponseDTO{
    private Long clientId;
    private String firstName;
    private String lastName;
}


