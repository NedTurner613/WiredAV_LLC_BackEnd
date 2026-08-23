package com.wiredav.app.entities;

import com.wiredav.app.dtos.appointmentDTOs.GetAppointmentResponsePersonnelDTO;
import com.wiredav.app.dtos.appointmentDTOs.MakeAppointmentResponsePersonnelDTO;
import com.wiredav.app.dtos.personnelDTOs.PersonnelInfoDTO;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "personnel")
public class Personnel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "personnelId", nullable = false)
    private long personnelId;

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "lastName", nullable = false)
    private String lastName;

    @Column(name = "role", nullable = false)
    private Integer role;

    @Column(name = "personnelEmail", nullable = false)
    private String personnelEmail;

    @Column(name = "password", nullable = false)
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

    public void setPersonnelId(long personnelId) {
        this.personnelId = personnelId;
    }

    public long getPersonnelId() {
        return personnelId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Integer getRole() {
        return role;
    }

    public void setPersonnelEmail(String personnelEmail) {
        this.personnelEmail = personnelEmail;
    }

    public String getPersonnelEmail() {
        return personnelEmail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setAppointments(Set<Appointments> appointments) {
        this.appointments = appointments;
    }

    public Set<Appointments> getAppointments() {
        return appointments;
    }

    //Add toResponse method to all entities
    public PersonnelInfoDTO toPersonnelInfoDTO() {
        PersonnelInfoDTO dto = new PersonnelInfoDTO(
                this.personnelId,
                this.firstName,
                this.lastName,
                this.personnelEmail,
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
}
