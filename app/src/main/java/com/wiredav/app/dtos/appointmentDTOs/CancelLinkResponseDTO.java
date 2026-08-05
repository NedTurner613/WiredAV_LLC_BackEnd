package com.wiredav.app.dtos.appointmentDTOs;

import com.wiredav.app.enums.ApptStatus;
import com.wiredav.app.enums.ApptType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CancelLinkResponseDTO {
    private Long apptId;
    private ApptStatus status;
    private CancelLinkResponseClientDTO clientInfo;
    private TimeslotDTO timeslot;
    private ApptType apptType;
}

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class CancelLinkResponseClientDTO{
    private Long clientId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
}
