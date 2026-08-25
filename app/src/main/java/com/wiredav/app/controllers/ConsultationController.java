package com.wiredav.app.controllers;

import com.wiredav.app.dtos.appointmentDTOs.CancelLinkResponseDTO;
import com.wiredav.app.dtos.appointmentDTOs.GetConsultBlockResponseDTO;
import com.wiredav.app.dtos.appointmentDTOs.RequestConsultRequestDTO;
import com.wiredav.app.dtos.appointmentDTOs.RequestConsultResponseDTO;
import com.wiredav.app.services.AppointmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("api/v1/consultations")
@Tag(name = "Consultation Controller")
public class ConsultationController {
    private final AppointmentService appointmentService;

    public ConsultationController(
            AppointmentService appointmentService
    ) {
        this.appointmentService = appointmentService;
    }

    @GetMapping("/{date}")
    @Operation(summary = "getConsultBlock")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<GetConsultBlockResponseDTO> getConsultBlock(@PathVariable("date") LocalDate date){
        System.out.println("getConsultBlock Controller for date " + date);
        var consultBlock = appointmentService.getConsultBlock(date);
        return ResponseEntity
                .accepted()
                .body(consultBlock);
    }

    @PostMapping("")
    @Operation(summary = "requestConsultation")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<RequestConsultResponseDTO> requestConsultation(@RequestBody RequestConsultRequestDTO request){
        var newAppt = appointmentService.requestConsultation(request).toRequestConsultResponseDTO();
        return ResponseEntity
                .accepted()
                .body(newAppt);
    }

    @PutMapping("/{id}")
    @Operation(summary = "cancelLink")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CancelLinkResponseDTO> cancelLink(@PathVariable("id") Long id){
        var appointment = appointmentService.cancelConsultationLink(id).toCancelLinkResponseDTO();
        return ResponseEntity
                .accepted()
                .body(appointment);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "cancelConsultation")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Void> cancelConsultation(@PathVariable("id") Long id){
        appointmentService.cancelConsultation(id);
        return ResponseEntity
                .accepted()
                .build();
    }

}
