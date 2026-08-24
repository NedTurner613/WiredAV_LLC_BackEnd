package com.wiredav.app.services;

import com.wiredav.app.dtos.appointmentDTOs.TimeslotDTO;
import com.wiredav.app.entities.Appointments;
import com.wiredav.app.entities.Timeslot;
import com.wiredav.app.repositories.PersonnelRepository;
import com.wiredav.app.repositories.TimeslotRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TimeslotService {
    private final TimeslotRepository timeslotRepository;
    private final PersonnelRepository personnelRepository;

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
        return timeslotRepository.findByAppointmentsId(appointmentId).orElse(null);
    }

    public List<Timeslot> getAllTimeslotsAtStartTime(LocalDateTime startTime) {
        return timeslotRepository.findAllByStartTime(startTime).orElse(null);
    }

    /**
    Returns True if the timeslot being checked has at least one availability
        an availability qualifies as follows:
            the number of appointments at that timeslot with a status of 1 (Requested) or 2 (Open) is less than the number of available technicians
     */
    public Boolean isTimeslotAvailable(TimeslotDTO timeslot){
        //get all appointments at that time slot with a status of 1 or 2
        var noOfActiveTimeslotsAtTime = getAllTimeslotsAtStartTime(timeslot.startTime()).stream()
                .filter(t -> t.getAppointments().getStatus().equals(1) || t.getAppointments().getStatus().equals(2)).count();
        // compare the number of appointments to the number of available technicians
        var numberOfAvailableTechs = personnelRepository.findAllByRole(2).stream().count();
        return noOfActiveTimeslotsAtTime < numberOfAvailableTechs;
    }

    public Boolean isTimeslotAvailable(Timeslot timeslot){
        var noOfActiveTimeslotsAtTime = getAllTimeslotsAtStartTime(timeslot.getStartTime()).stream()
                .filter(t -> t.getAppointments().getStatus().equals(1) || t.getAppointments().getStatus().equals(2)).count();
        var numberOfAvailableTechs = personnelRepository.findAllByRole(2).stream().count();
        return noOfActiveTimeslotsAtTime < numberOfAvailableTechs;
    }


}
