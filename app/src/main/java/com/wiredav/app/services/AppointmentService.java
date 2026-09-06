package com.wiredav.app.services;

import com.wiredav.app.dtos.appointmentDTOs.*;
import com.wiredav.app.entities.Appointments;
import com.wiredav.app.entities.Clients;
import com.wiredav.app.entities.Timeslot;
import com.wiredav.app.repositories.AppointmentsRepository;
import com.wiredav.app.repositories.ClientsRepository;
import com.wiredav.app.repositories.PersonnelRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

    public Set<Appointments> getAppointmentsByPersonnelAndTimeframe(GetAppointmentsListRequestDTO request){
        return appointmentsRepository.findAppointmentsByPersonnelAndTimeframe(request.personnelIds(), request.timeFrame().startTime(), request.timeFrame().endTime()).orElse(null);
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
                .createdAt(request.createdAt())
                .updatedAt(LocalDateTime.now())
                .build();
        return appointmentsRepository.save(appointment);
    }



    //CONSULTATION LOGIC

    public GetConsultBlockResponseDTO getConsultBlock(LocalDate date){
        List<TimeslotDTO> unavailableTimeslots = new ArrayList<>();
        for(int h=9; h<18;h++){
//            TimeslotDTO timeslot = new TimeslotDTO(date.atTime(h, 0,0,0), date.atTime(h+1, 0,0,0));
            TimeslotDTO timeslot = new TimeslotDTO(LocalDateTime.of(date, LocalTime.of(h, 0,0)), date.atTime(h+1, 0,0,0));
            // if timeslot is unavailable, that timeslot will be added to the unavailableTimeslots object
            if(!timeslotService.isTimeslotAvailable(timeslot)) {
                unavailableTimeslots.add(new TimeslotDTO(date.atTime(h, 0), date.atTime(h+1, 0)));
            }
        }
        return new GetConsultBlockResponseDTO(unavailableTimeslots);
    }

    public Appointments requestConsultation(RequestConsultRequestDTO request){
        Timeslot timeslot = Timeslot.builder()
                .startTime(request.timeslot().startTime())
                .endTime(request.timeslot().endTime())
                .build();
        //first check if the timeslot is available
        if(timeslotService.isTimeslotAvailable(timeslot)) {
            //check if a client with that email already exists
            Clients client = clientsRepository.findByEmailAddress(request.clientInfo().email()).orElse(null);
            if(client == null) {
                client = Clients.builder()
                        .firstName(request.clientInfo().firstName())
                        .lastName(request.clientInfo().lastName())
                        .emailAddress(request.clientInfo().email())
                        .phoneNumber(request.clientInfo().phoneNumber())
                        .build();
            }else{
                client.setFirstName(request.clientInfo().firstName());
                client.setLastName(request.clientInfo().lastName());
                client.setPhoneNumber(request.clientInfo().phoneNumber());
            }
            //create the new client/update the extant client with new info
            client = clientsRepository.save(client);
            Appointments appointment = Appointments.builder()
                    .client(client)
                    .personnel(null)
                    .timeslot(timeslot)
                    .status(1)
                    .appointmentType(1)
                    .createdAt(LocalDateTime.now())
                    .build();
            //schedule the appointment
            return appointmentsRepository.save(appointment);
        }
        return null;
    }

    public Appointments cancelConsultationLink(Long apptId){
        return appointmentsRepository.findById(apptId).orElse(null);
    }

    public void cancelConsultation(Long apptId){
        var appointment = appointmentsRepository.findById(apptId).orElse(null);
        if(appointment != null){
            appointment.setStatus(3);
            appointmentsRepository.save(appointment);
        }
    }

}
