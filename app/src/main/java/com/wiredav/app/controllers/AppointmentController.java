package com.wiredav.app.controllers;

import com.wiredav.app.dtos.appointmentDTOs.*;
import com.wiredav.app.entities.Appointments;
import com.wiredav.app.services.AppointmentService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(
            AppointmentService appointmentService
    ) {
        this.appointmentService = appointmentService;
    }

    @GetMapping("/{id}")
    @Operation(summary = "getAppointment")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<GetAppointmentResponseDTO> getAppointment(@PathVariable("id") Long id) {
        var appointment = appointmentService.getAppointmentById(id).toGetAppointmentResponseDTO();
        return ResponseEntity
                .accepted()
                .body(appointment);
    }

    @PostMapping("/list")
    @Operation(summary = "getAppointmentsList")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<GetAppointmentsListResponseDTO> getAppointmentsList(@RequestBody GetAppointmentsListRequestDTO request){
        var appointmentsList = Appointments.toGetAppointmentsListResponseDTO(appointmentService.getAppointmentsByPersonnelAndTimeframe(request));
        return ResponseEntity
                .accepted()
                .body(appointmentsList);
    }

    @PostMapping("")
    @Operation(summary = "makeAppointment")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<MakeAppointmentResponseDTO> makeAppointment(@RequestBody MakeAppointmentRequestDTO apptRequest) {
        var response = appointmentService.makeAppointment(apptRequest).toMakeAppointmentResponseDTO();
        return ResponseEntity
                .accepted()
                .body(response);
    }

    @PutMapping("")
    @Operation(summary = "modifyAppointment")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ModifyAppointmentResponseDTO> modifyAppointment(@RequestBody ModifyAppointmentRequestDTO request){
        var response = appointmentService.modifyAppointment(request).toModifyAppointmentResponseDTO();
        return ResponseEntity
                .accepted()
                .body(response);
    }


}
