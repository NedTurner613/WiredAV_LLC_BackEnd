package com.appointments.repository;

import com.appointments.entity.Appointment;
import com.appointments.entity.AppointmentStatus;
import com.appointments.entity.AppointmentType;
import com.appointments.entity.Client;
import com.appointments.entity.Personnel;
import com.appointments.entity.PersonnelRole;
import com.appointments.entity.Timeslot;
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
    private PersonnelRoleRepository personnelRoleRepository;

    @Autowired
    private TimeslotRepository timeslotRepository;

    @Autowired
    private AppointmentStatusRepository appointmentStatusRepository;

    @Autowired
    private AppointmentTypeRepository appointmentTypeRepository;

    @Test
    void savesAppointmentWithRelationsAndLookupTables() {
        Client client = new Client();
        client.setFirstName("Ada");
        client.setLastName("Lovelace");
        client = clientRepository.save(client);

        PersonnelRole adminRole = new PersonnelRole();
        adminRole.setPersonnelRole("ADMIN");
        adminRole = personnelRoleRepository.save(adminRole);

        Personnel personnel = new Personnel();
        personnel.setFirstName("Grace");
        personnel.setLastName("Hopper");
        personnel.setRole(adminRole);
        personnel = personnelRepository.save(personnel);

        Timeslot timeslot = new Timeslot();
        timeslot.setStartTime(LocalDateTime.of(2026, 8, 10, 9, 0));
        timeslot.setEndTime(LocalDateTime.of(2026, 8, 10, 9, 30));
        timeslot = timeslotRepository.save(timeslot);

        AppointmentStatus requestedStatus = new AppointmentStatus();
        requestedStatus.setAppointmentStatus("REQUESTED");
        requestedStatus = appointmentStatusRepository.save(requestedStatus);

        AppointmentType consultationType = new AppointmentType();
        consultationType.setAppointmentType("CONSULTATION");
        consultationType = appointmentTypeRepository.save(consultationType);

        Appointment appointment = new Appointment();
        appointment.setClient(client);
        appointment.setPersonnel(personnel);
        appointment.setTimeslot(timeslot);
        appointment.setStatus(requestedStatus);
        appointment.setAppointmentType(consultationType);
        appointment.setCreatedAt(LocalDateTime.now());
        appointment.setUpdatedAt(LocalDateTime.now());

        Appointment saved = appointmentRepository.save(appointment);

        Optional<Appointment> found = appointmentRepository.findById(saved.getAppointmentId());
        assertThat(found).isPresent();
        assertThat(found.get().getStatus().getAppointmentStatus()).isEqualTo("REQUESTED");
        assertThat(found.get().getAppointmentType().getAppointmentType()).isEqualTo("CONSULTATION");
        assertThat(found.get().getClient().getClientId()).isEqualTo(client.getClientId());
        assertThat(found.get().getPersonnel().getPersonnelId()).isEqualTo(personnel.getPersonnelId());
        assertThat(found.get().getTimeslot().getTimeslotId()).isEqualTo(timeslot.getTimeslotId());
    }
}
