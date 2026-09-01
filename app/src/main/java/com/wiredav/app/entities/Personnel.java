package com.wiredav.app.entities;

import com.wiredav.app.dtos.appointmentDTOs.GetAppointmentResponsePersonnelDTO;
import com.wiredav.app.dtos.appointmentDTOs.GetAppointmentsListResponseEntryPersonnelDTO;
import com.wiredav.app.dtos.appointmentDTOs.MakeAppointmentResponsePersonnelDTO;
import com.wiredav.app.dtos.personnelDTOs.AddTechnicianResponseDTO;
import com.wiredav.app.dtos.personnelDTOs.GetPersonnelListResponseDTO;
import com.wiredav.app.dtos.personnelDTOs.PersonnelInfoDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "personnel")
@Getter
@Setter
@AllArgsConstructor
@Builder
public class Personnel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "personnel_id", nullable = false)
    private long personnelId;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "role", nullable = false)
    private Integer role;

    @Column(name = "personnel_email", nullable = false)
    private String personnelEmail;

    @Column(name = "password", nullable = true)
    private String password;

    @OneToMany(mappedBy = "personnel", cascade = CascadeType.ALL)
    private Set<Appointments> appointments = new HashSet<>();

    //For Admins
    public Personnel(String firstName, String lastName, Integer role, String personnelEmail, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.personnelEmail = personnelEmail;
        this.password = password;
    }

    //For technicians
    public Personnel(String firstName, String lastName, Integer role, String personnelEmail) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.personnelEmail = personnelEmail;
    }

    public Personnel() {}

    //Add toResponse method to all entities
    public PersonnelInfoDTO toResponse() {
        PersonnelInfoDTO dto = new PersonnelInfoDTO(
                this.personnelId,
                this.firstName,
                this.lastName,
                this.personnelEmail,
                this.role
        );

        return dto;
    }

    //Register Personnel response
    public AddTechnicianResponseDTO toAddPersonnelResponseDTO() {
        AddTechnicianResponseDTO dto = new AddTechnicianResponseDTO(
                this.personnelId,
                this.firstName,
                this.lastName,
                this.personnelEmail,
                this.role
        );

        return dto;
    }

    //Get Personnel list response
    public GetPersonnelListResponseDTO toPersonnelListResponseDTO() {
        GetPersonnelListResponseDTO dto = new GetPersonnelListResponseDTO(
                this.personnelId,
                this.firstName,
                this.lastName,
                this.role
        );

        return dto;
    }

    public GetAppointmentResponsePersonnelDTO toGetAppointmentResponsePersonnelDTO() {
        return new GetAppointmentResponsePersonnelDTO(
                this.personnelId,
                this.firstName,
                this.lastName,
                this.role
        );
    }

    public MakeAppointmentResponsePersonnelDTO toMakeAppointmentResponsePersonnelDTO() {
        return new MakeAppointmentResponsePersonnelDTO(
                this.personnelId,
                this.firstName,
                this.lastName
        );
    }

    public GetAppointmentsListResponseEntryPersonnelDTO toGetAppointmentsListResponseEntryPersonnelDTO(){
        return new GetAppointmentsListResponseEntryPersonnelDTO(
                this.personnelId,
                this.firstName,
                this.lastName
        );
    }
}
