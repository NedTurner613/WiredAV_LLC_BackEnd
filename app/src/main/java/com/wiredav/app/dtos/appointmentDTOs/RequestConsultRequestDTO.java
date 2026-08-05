package com.wiredav.app.dtos.appointmentDTOs;

import com.wiredav.app.dtos.clientDTOs.AddClientRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestConsultRequestDTO {
    private AddClientRequestDTO clientInfo;
}
