package com.wiredav.app.services;

import com.wiredav.app.dtos.appointmentDTOs.TimeslotDTO;
import com.wiredav.app.entities.Appointments;
import com.wiredav.app.entities.Timeslot;
import com.wiredav.app.repositories.TimeslotRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TimeslotService {
    private final TimeslotRepository timeslotRepository;

    public Timeslot makeTimeslot(TimeslotDTO timeslotRequest) {
        Timeslot timeslot = Timeslot.builder()
                .startTime(timeslotRequest.startTime())
                .endTime(timeslotRequest.endTime())
                .build();
        return timeslotRepository.save(timeslot);
    }

    public void setTimeslotAppointment(Timeslot timeslot, Appointments appointment) {
        timeslot.setAppointments(appointment);
        timeslotRepository.save(timeslot);
    }
}
