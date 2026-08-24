package com.wiredav.app.controllers;

import com.wiredav.app.dtos.appointmentDTOs.CancelLinkResponseDTO;
import com.wiredav.app.dtos.appointmentDTOs.GetConsultBlockResponseDTO;
import com.wiredav.app.dtos.appointmentDTOs.RequestConsultRequestDTO;
import com.wiredav.app.services.AppointmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("api/v1/consultations")
public class ConsultationController {
    private final AppointmentService appointmentService;

    public ConsultationController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping("/{date}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<GetConsultBlockResponseDTO> getConsultBlock(@PathVariable("date") LocalDate date){
        var consultBlock = appointmentService.getConsultBlock(date);
        return ResponseEntity
                .accepted()
                .body(consultBlock);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Void> requestConsultation(@RequestBody RequestConsultRequestDTO request){
        appointmentService.requestConsultation(request);
        return ResponseEntity
                .accepted()
                .build();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CancelLinkResponseDTO> cancelLink(@PathVariable("id") Long id){
        var appointment = appointmentService.cancelConsultationLink(id).toCancelLinkResponseDTO();
        return ResponseEntity
                .accepted()
                .body(appointment);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Void> cancelConsultation(@PathVariable("id") Long id){
        appointmentService.cancelConsultation(id);
        return ResponseEntity
                .accepted()
                .build();
    }

}
