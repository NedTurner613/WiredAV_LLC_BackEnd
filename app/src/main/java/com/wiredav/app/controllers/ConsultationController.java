package com.wiredav.app.controllers;

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

//    @PostMapping("")
//    @ResponseStatus(HttpStatus.CREATED)
//    public ResponseEntity<Void> requestConsultation(@RequestBody RequestConsultRequestDTO request){
//
//    }


//
//    //region Client Side Methods

//
//    @PostMapping("/consult")
//    public ResponseEntity<Void> RequestConsult(@RequestBody RequestConsultRequestDTO consultRequest){
//        appointmentService.RequestConsult(consultRequest);
//        return ResponseEntity
//                .status(HttpStatus.OK)
//                .build();
//    }
//
//    @PutMapping("/consult/{id}")
//    public ResponseEntity<CancelLinkResponseDTO> CancelLink(@PathVariable("id") Long id){
//        CancelLinkResponseDTO apptDetails = appointmentService.CancelLink(id);
//        return ResponseEntity
//                .status(HttpStatus.OK)
//                .body(apptDetails);
//    }
//
//    @DeleteMapping("/consult/{id}")
//    public ResponseEntity<Void> CancelConsult(@PathVariable("id") Long id){
//        appointmentService.CancelConsult(id);
//        return ResponseEntity
//                .status(HttpStatus.OK)
//                .build();
//    }

    //endregion

}
