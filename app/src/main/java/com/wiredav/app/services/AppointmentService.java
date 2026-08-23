package com.wiredav.app.services;

import com.wiredav.app.dtos.appointmentDTOs.*;
import com.wiredav.app.entities.Appointments;
import com.wiredav.app.entities.Timeslot;
import com.wiredav.app.repositories.AppointmentsRepository;
import com.wiredav.app.repositories.ClientsRepository;
import com.wiredav.app.repositories.PersonnelRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
@Transactional
public class AppointmentService {

    private final AppointmentsRepository appointmentsRepository;
    private final TimeslotService timeslotService;
    private final ClientsRepository clientsRepository;
    private final PersonnelRepository personnelRepository;

    public Appointments getAppointmentById(Long apptId) {
        return appointmentsRepository.findById(apptId).orElse(null);
    }

    public Appointments makeAppointment(MakeAppointmentRequestDTO apptRequest) {
        Timeslot timeslot = timeslotService.makeTimeslot(apptRequest.timeslot());
        Appointments appointment = Appointments.builder()
                .client(clientsRepository.findById(apptRequest.clientId()).orElse(null))
                .personnel(personnelRepository.findById(apptRequest.personnelId()).orElse(null))
                .timeslot(timeslot)
                .status(apptRequest.status())
                .appointmentType(apptRequest.apptType())
                .createdAt(LocalDate.now().atStartOfDay())
                .build();
        Appointments newAppointment = appointmentsRepository.save(appointment);
        timeslotService.setTimeslotAppointment(timeslot, newAppointment);
        return newAppointment;
    }

//    public GetAppointmentsResponseDTO GetAppointments(){
//        return new GetAppointmentsResponseDTO();
//    }
//
//    public GetAppointmentResponseDTO GetAppointment(Long apptId){
//        return new GetAppointmentResponseDTO();
//    }
//
//    public MakeAppointmentResponseDTO MakeAppointment( MakeAppointmentRequestDTO apptRequest){
//        return new MakeAppointmentResponseDTO();
//    }
//
//    public ModifyAppointmentResponseDTO ModifyAppointment(ModifyAppointmentRequestDTO modifyRequest){
//        return new ModifyAppointmentResponseDTO();
//    }
//
//
//    //region Client Side Logic
//
//    public GetConsultBlockResponseDTO GetConsultBlock(LocalDate date){
//        return new GetConsultBlockResponseDTO();
//    }
//
//    public void RequestConsult(RequestConsultRequestDTO consultRequest){
//    }
//
//    public CancelLinkResponseDTO CancelLink(Long apptId){
//        return new CancelLinkResponseDTO();
//    }
//
//    public void CancelConsult(Long apptId){
//
//    }
//
//    //
}
