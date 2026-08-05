package com.wiredav.app.dtos.personnelDTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUserRequestDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
