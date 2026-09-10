package com.wiredav.app.entities;

import com.wiredav.app.dtos.clientDTOs.AddClientResponseDTO;
import com.wiredav.app.dtos.clientDTOs.GetClientResponseDTO;
import com.wiredav.app.dtos.appointmentDTOs.*;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "clients")
@Getter
@Setter
@AllArgsConstructor
@Builder
public class Clients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private Long clientId;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "email_address", nullable = false)
    private String emailAddress;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private Set<Appointments> appointments = new HashSet<>();

    public Clients() {}

    public Clients(String firstName, String lastName, String phoneNumber, String emailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    public CancelLinkResponseClientDTO toCancelLinkResponseClientDTO() {
        return new CancelLinkResponseClientDTO(
                this.clientId,
                this.firstName,
                this.lastName,
                this.phoneNumber,
                this.emailAddress
        );
    }

    public GetAppointmentResponseClientDTO toGetAppointmentResponseClientDTO() {
        return new GetAppointmentResponseClientDTO(
                this.clientId,
                this.firstName,
                this.lastName
        );
    }

    public GetClientResponseDTO toGetClientResponseDTO() {
        return new GetClientResponseDTO(
                this.clientId,
                this.firstName,
                this.lastName,
                this.emailAddress,
                this.phoneNumber
        );
    }

    public MakeAppointmentResponseClientDTO toMakeAppointmentResponseClientDTO() {
        return new MakeAppointmentResponseClientDTO(
                this.clientId,
                this.firstName,
                this.lastName,
                this.phoneNumber,
                this.emailAddress
        );
    }

    public ModifyAppointmentResponseClientDTO toModifyAppointmentResponseClientDTO() {
        return new ModifyAppointmentResponseClientDTO(
                this.clientId,
                this.firstName,
                this.lastName
        );
    }

    public RequestConsultClientDTO toRequestConsultClientResponseDTO(){
        return new RequestConsultClientDTO(
                this.firstName,
                this.lastName,
                this.emailAddress,
                this.phoneNumber
        );
    }

    // Add new Client response
    public AddClientResponseDTO toAddClientResponseDTO() {
        return new AddClientResponseDTO(
                this.clientId,
                this.firstName,
                this.lastName,
                this.emailAddress,
                this.phoneNumber
        );
    }

    public GetClientResponseDTO toGetClientByIdResponseDTO () {
        return new GetClientResponseDTO(
                this.clientId,
                this.firstName,
                this.lastName,
                this.emailAddress,
                this.phoneNumber
        );
    }

    public GetAppointmentsListResponseEntryClientDTO toGetAppointmentsListResponseEntryClientDTO(){
        return new GetAppointmentsListResponseEntryClientDTO(
                this.clientId,
                this.firstName,
                this.lastName
        );
    }
}