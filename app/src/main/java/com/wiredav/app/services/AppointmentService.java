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
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Transactional
public class AppointmentService {

    private final AppointmentsRepository appointmentsRepository;
    private final ClientService clientService;
    private final PersonnelService personnelService;
    private final TimeslotService timeslotService;
    private final ClientsRepository clientsRepository;
    private final PersonnelRepository personnelRepository;

    public Appointments getAppointmentById(Long apptId) {
        return appointmentsRepository.findById(apptId).orElse(null);
    }

    public Set<Appointments> getAppointmentsByPersonnelAndTimeframe(GetAppointmentsListRequestDTO request){
        return appointmentsRepository.findAppointmentsByPersonnelAndTimeframe(request.personnelIds(), request.timeFrame().startTime(), request.timeFrame().endTime());
    }

    public Appointments makeAppointment(MakeAppointmentRequestDTO apptRequest) {
        Timeslot timeslot = timeslotService.makeTimeslot(apptRequest.timeslot());
        Appointments appointment = Appointments.builder()
                .client(clientsRepository.findById(apptRequest.clientId()).orElse(null))
                .personnel(personnelRepository.findById(apptRequest.personnelId()).orElse(null))
                .timeslot(timeslot)
                .status(apptRequest.status())
                .appointmentType(apptRequest.apptType())
                .createdAt(LocalDateTime.now())
                .build();
        Appointments newAppointment = appointmentsRepository.save(appointment);
        timeslotService.setTimeslotAppointment(timeslot, newAppointment);
        return newAppointment;
    }

    public Appointments modifyAppointment(ModifyAppointmentRequestDTO request){
        Timeslot timeslot = timeslotService.getTimeslotByAppointmentId(request.apptId());
        if(timeslot !=null){
            timeslot.setStartTime(request.timeslot().startTime());
            timeslot.setEndTime(request.timeslot().endTime());
            timeslotService.updateTimeslot(timeslot);
        }
        Appointments appointment = Appointments.builder()
                .appointmentId(request.apptId())
                .status(request.status())
                .client(clientsRepository.findById(request.clientId()).orElse(null))
                .personnel(personnelRepository.findById(request.personnelId()).orElse(null))
                .timeslot(timeslot)
                .appointmentType(request.apptType())
                .updatedAt(LocalDateTime.now())
                .build();
        return appointmentsRepository.save(appointment);
    }



    //CONSULTATION LOGIC

    public GetConsultBlockResponseDTO getConsultBlock(LocalDate date){
        List<TimeslotDTO> timeslots = new ArrayList<TimeslotDTO>();
        for(int h=9; h<18;h++){
            if(timeslotService.checkTimeslotAvailability(date.atTime(h, 0), date.atTime(h+1, 0))) {
                timeslots.add(new TimeslotDTO(date.atTime(h, 0), date.atTime(h+1, 0)));
            }
        }
        return new GetConsultBlockResponseDTO(timeslots);
    }

    public void requestConsultation(RequestConsultRequestDTO request){

    }

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
