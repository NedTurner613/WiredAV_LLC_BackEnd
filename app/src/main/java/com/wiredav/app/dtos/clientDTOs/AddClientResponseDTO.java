package com.wiredav.app.dtos.clientDTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddClientResponseDTO {
    private Long clientId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
}
