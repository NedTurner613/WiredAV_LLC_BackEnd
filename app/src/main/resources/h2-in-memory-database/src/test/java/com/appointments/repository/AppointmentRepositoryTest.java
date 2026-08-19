package com.appointments.repository;

import com.appointments.entity.Appointment;
import com.appointments.entity.Client;
import com.appointments.entity.Personnel;
import com.appointments.entity.Timeslot;
import com.appointments.enums.AppointmentStatus;
import com.appointments.enums.AppointmentType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class AppointmentRepositoryTest {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private PersonnelRepository personnelRepository;

    @Autowired
    private TimeslotRepository timeslotRepository;

    @Test
    void savesAppointmentWithRelationsAndEnums() {
        Client client = new Client();
        client.setFirstName("Ada");
        client.setLastName("Lovelace");
        client = clientRepository.save(client);

        Personnel personnel = new Personnel();
        personnel.setFirstName("Grace");
        personnel.setLastName("Hopper");
        personnel.setRole("ADMIN");
        personnel = personnelRepository.save(personnel);

        Timeslot timeslot = new Timeslot();
        timeslot.setStartTime(LocalDateTime.of(2026, 8, 10, 9, 0));
        timeslot.setEndTime(LocalDateTime.of(2026, 8, 10, 9, 30));
        timeslot = timeslotRepository.save(timeslot);

        Appointment appointment = new Appointment();
        appointment.setClient(client);
        appointment.setPersonnel(personnel);
        appointment.setTimeslot(timeslot);
        appointment.setStatus(AppointmentStatus.REQUESTED);
        appointment.setAppointmentType(AppointmentType.CONSULTATION);
        appointment.setCreatedAt(LocalDateTime.now());
        appointment.setUpdatedAt(LocalDateTime.now());

        Appointment saved = appointmentRepository.save(appointment);

        Optional<Appointment> found = appointmentRepository.findById(saved.getAppointmentId());
        assertThat(found).isPresent();
        assertThat(found.get().getStatus()).isEqualTo(AppointmentStatus.REQUESTED);
        assertThat(found.get().getAppointmentType()).isEqualTo(AppointmentType.CONSULTATION);
        assertThat(found.get().getClient().getClientId()).isEqualTo(client.getClientId());
        assertThat(found.get().getPersonnel().getPersonnelId()).isEqualTo(personnel.getPersonnelId());
        assertThat(found.get().getTimeslot().getTimeslotId()).isEqualTo(timeslot.getTimeslotId());
    }
}
