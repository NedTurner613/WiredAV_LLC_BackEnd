package com.wiredav.app.services;

import com.wiredav.app.dtos.AppointmentResponseDTO;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Service
public class AppointmentService {

    public List<AppointmentResponseDTO> GetAppointments(){
        return new ArrayList<AppointmentResponseDTO>();
    }

    public AppointmentResponseDTO GetAppointment(){
        return new AppointmentResponseDTO();
    }
}
