package com.wiredav.app.controllers;

import com.wiredav.app.dtos.appointmentDTOs.*;
import com.wiredav.app.services.AppointmentService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping("/appointments")
    public ResponseEntity<GetAppointmentsResponseDTO> GetAppointments(){
        GetAppointmentsResponseDTO list = appointmentService.GetAppointments();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(list);
    }

    @GetMapping("/appointment/{id}")
    public ResponseEntity<GetAppointmentResponseDTO> GetAppointment(@PathVariable("id") Long id){
        GetAppointmentResponseDTO appointment = appointmentService.GetAppointment(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(appointment);
    }

    @PostMapping("/appointment")
    public ResponseEntity<MakeAppointmentResponseDTO> MakeAppointment(@RequestBody MakeAppointmentRequestDTO apptRequest){
        MakeAppointmentResponseDTO response = appointmentService.MakeAppointment(apptRequest);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    @PutMapping("/appointment")
    public ResponseEntity<ModifyAppointmentResponseDTO> ModifyAppointment(@RequestBody ModifyAppointmentRequestDTO modifyRequest){
        ModifyAppointmentResponseDTO newApptInfo = appointmentService.ModifyAppointment(modifyRequest);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(newApptInfo);
    }



    //region Client Side Methods
    @GetMapping("/consult/{date}")
    public ResponseEntity<Void> GetConsultBlock(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

    @PostMapping("/consult")
    public ResponseEntity<Void> RequestConsult(@RequestBody RequestConsultRequestDTO consultRequest){
        appointmentService.RequestConsult(consultRequest);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

    @PutMapping("/consult/{id}")
    public ResponseEntity<CancelLinkResponseDTO> CancelLink(@PathVariable("id") Long id){
        CancelLinkResponseDTO apptDetails = appointmentService.CancelLink(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(apptDetails);
    }

    @DeleteMapping("/consult/{id}")
    public ResponseEntity<Void> CancelConsult(@PathVariable("id") Long id){
        appointmentService.CancelConsult(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

    //endregion


}
