package com.wiredav.app.controllers;

import com.wiredav.app.dtos.AppointmentResponseDTO;
import com.wiredav.app.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RestController
@RequestMapping("/appt")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping("/appointments")
    public List<AppointmentResponseDTO> GetAppointments(){
        return appointmentService.GetAppointments();
    }

    @GetMapping("/appointment")
    public AppointmentResponseDTO GetAppointment(){
        return appointmentService.GetAppointment();
    }
}
