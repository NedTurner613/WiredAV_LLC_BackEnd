package com.wiredav.app.entities;

import com.wiredav.app.dtos.appointmentDTOs.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "appointments")
@Getter
@Setter
@AllArgsConstructor
@Builder
public class Appointments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointment_id", nullable = false)
    private long appointmentId;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Clients client;

    @Column(name = "status", nullable = false)
    private Integer status;
    /*
        1: Requested
        2: Open
        3: Closed
     */

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "timeslot_id", referencedColumnName = "timeslot_id")
    private Timeslot timeslot;

    @ManyToOne
    @JoinColumn(name = "personnel_id", nullable = true)
    private Personnel personnel;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = true)
    private LocalDateTime updatedAt;

    @Column(name = "appointment_type", nullable = false)
    private Integer appointmentType;
    /*
        1: Consultation
     */

    public Appointments(Integer status, Timeslot timeslotId, Integer appointmentType, Personnel personnel, Clients client) {
        this.status = status;
        this.timeslot = timeslotId;
        this.appointmentType = appointmentType;
        this.personnel = personnel;
        this.client = client;
        //Create entity functions to set updatedAt and createdAt values
    }

    public Appointments() {
    }

    public CancelLinkResponseDTO toCancelLinkResponseDTO() {
        return new CancelLinkResponseDTO(
                this.appointmentId,
                this.status,
                this.client.toCancelLinkResponseClientDTO(),
                this.timeslot.toTimeslotDTO(),
                this.appointmentType
        );
    }

    public GetAppointmentResponseDTO toGetAppointmentResponseDTO() {
        return new GetAppointmentResponseDTO(
                this.appointmentId,
                this.status,
                this.personnel != null ? this.personnel.toGetAppointmentResponsePersonnelDTO() : null,
                this.client.toGetAppointmentResponseClientDTO(),
                this.timeslot.toTimeslotWithIdDTO(),
                this.appointmentType,
                this.createdAt,
                this.updatedAt
        );
    }

    public GetAppointmentsListResponseEntryDTO toGetAppointmentsListResponseEntryDTO() {
        return new GetAppointmentsListResponseEntryDTO(
                this.appointmentId,
                this.status,
                this.client.toGetClientResponseDTO(),
                this.personnel != null ? this.personnel.toPersonnelInfoDTO() : null,
                this.timeslot.toTimeslotDTO(),
                this.appointmentType
        );
    }

    public static GetAppointmentsListResponseDTO toGetAppointmentsListResponseDTO(Set<Appointments> appointments) {
        Set<GetAppointmentsListResponseEntryDTO> appointmentEntries = appointments.stream()
                .map(Appointments::toGetAppointmentsListResponseEntryDTO)
                .collect(java.util.stream.Collectors.toSet());
        return new GetAppointmentsListResponseDTO(appointmentEntries);
    }

    public MakeAppointmentResponseDTO toMakeAppointmentResponseDTO() {
        return new MakeAppointmentResponseDTO(
                this.appointmentId,
                this.status,
                this.personnel.toMakeAppointmentResponsePersonnelDTO(),
                this.client.toMakeAppointmentResponseClientDTO(),
                this.timeslot.toTimeslotWithIdDTO(),
                this.appointmentType
        );
    }

    public ModifyAppointmentResponseDTO toModifyAppointmentResponseDTO() {
        return new ModifyAppointmentResponseDTO(
                this.appointmentId,
                this.status,
                this.client.toModifyAppointmentResponseClientDTO(),
                this.personnel.toPersonnelInfoDTO(),
                this.timeslot.toTimeslotWithIdDTO(),
                this.appointmentType,
                this.createdAt,
                this.updatedAt
        );
    }

    public RequestConsultResponseDTO toRequestConsultResponseDTO(){
        return new RequestConsultResponseDTO(
                this.client.toRequestConsultClientResponseDTO(),
                this.timeslot.toTimeslotDTO()
        );
    }

}