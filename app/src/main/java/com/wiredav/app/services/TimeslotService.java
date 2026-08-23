package com.wiredav.app.services;

import com.wiredav.app.dtos.appointmentDTOs.TimeslotDTO;
import com.wiredav.app.entities.Appointments;
import com.wiredav.app.entities.Timeslot;
import com.wiredav.app.repositories.TimeslotRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

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

    public void updateTimeslot(Timeslot timeslot) {
        timeslotRepository.save(timeslot);
    }

    public Timeslot getTimeslotById(Long timeslotId) {
        return timeslotRepository.findById(timeslotId).orElse(null);
    }

    public Timeslot getTimeslotByAppointmentId(Long appointmentId) {
        return timeslotRepository.findByAppointmentsId(appointmentId);
    }

    public List<Timeslot> getAllTimeslotsAtStartTime(LocalDateTime startTime) {
        return timeslotRepository.findAllByStartTime(startTime);
    }

    /*
    Returns True if the timeslot being checked has at least one availability
        an availability qualifies as follows:
            the number of appointments at that timeslot with a status of 1 (Requested) or 2 (Open) is less than the number of available technicians
     */
    public Boolean checkTimeslotAvailability(LocalDateTime startTime, LocalDateTime endTime){
        var timeslots = getAllTimeslotsAtStartTime(startTime).stream()
                .filter(t -> t.getAppointments().getStatus().equals(1) || t.getAppointments().getStatus().equals(2));
        if(timeslots.count() < 5) return true;
        else return false;
    }
}
