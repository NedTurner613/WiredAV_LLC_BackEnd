package com.wiredav.app.services;

import com.wiredav.app.dtos.clientDTOs.AddClientRequestDTO;
import com.wiredav.app.dtos.clientDTOs.AddClientResponseDTO;
import com.wiredav.app.dtos.clientDTOs.GetClientResponseDTO;
import com.wiredav.app.entities.Clients;
import com.wiredav.app.exception.ClientNotFoundException;
import com.wiredav.app.repositories.ClientsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@RequiredArgsConstructor
public class ClientService {

    /* ClientService API Documentation
    *  Service class for managing client-related operations and handles the business logic for the following:
    *  - Creating new clients
    *  - Retrieving a list of clients
    *  - Managing clients
    *
    * ----Methods------
    *  1. Create Clients
    *     Creates a new client for consultations and/or appointments
    *
    *     Method Signature: public Clients createClient(Long clientId, String firstName, String lastName, String email, String phoneNumber)
    *
    *     Parameters:
    *     clientId (long): The unique identifier for the client
    *     firstName (String): Client's First Name
    *     lastName (String): Client's Last Name
    *     email (String): Unique email address for the client
    *     phoneNumber (String): Telephone number for client
    *
    *     Returns: Client object with generated client ID
    *     Throws: ClientException if the client doesn't provide an email and phone number.
    *
    *  2. Get Clients
    *     Shows the list of all clients
    *
    *     Method Signature: public GetClientsListResponseDTO getClients()
    *
    *     Parameters:
    *     None
    *
    *     Returns: List of Client objects with their clientId, firstName, and LastName
    *
    */
    private final ClientsRepository clientsRepository;

    @Transactional
    public AddClientResponseDTO createClient(AddClientRequestDTO request) {
        Clients newClient = Clients.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .emailAddress(request.email())
                .phoneNumber(request.phoneNumber())
                .build();

        Clients savedClient = clientsRepository.save(newClient);
        return savedClient.toAddClientResponseDTO();
    }

    @Transactional
    public Page<GetClientResponseDTO> getClients(Pageable pageable) {
        return clientsRepository.findAll(pageable).map(Clients::toGetClientResponseDTO);
    }

    @Transactional
    public GetClientResponseDTO getClientById(Long clientId) {
        return clientsRepository.findById(clientId)
                .map(Clients::toGetClientByIdResponseDTO)
                .orElseThrow(() -> new ClientNotFoundException(clientId));
    }
}