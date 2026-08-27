package com.wiredav.app.services;

import com.wiredav.app.dtos.clientDTOs.AddClientRequestDTO;
import com.wiredav.app.entities.Clients;
import com.wiredav.app.exception.ClientNotFoundException;
import com.wiredav.app.repositories.ClientsRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClientServiceTest {

    @Mock
    private ClientsRepository clientsRepository;

    @InjectMocks
    private ClientService clientService;

    @Test
    @DisplayName("createClient should map request fields and save new client")
    void createClient_ShouldMapAndSaveClient() {
        AddClientRequestDTO request = new AddClientRequestDTO("John", "Doe", "john.doe@example.com", "123-456-7890");
        Clients savedClient = Clients.builder()
                .clientId(1L)
                .firstName("John")
                .lastName("Doe")
                .emailAddress("john.doe@example.com")
                .phoneNumber("123-456-7890")
                .build();

        when(clientsRepository.save(any(Clients.class))).thenReturn(savedClient);

        // This will verify the return value of the saved client
        Clients result = clientService.createClient(request);
        assertThat(result).isNotNull();
        assertThat(result.getClientId()).isEqualTo(savedClient.getClientId());
        assertThat(result.getFirstName()).isEqualTo(savedClient.getFirstName());
        assertThat(result.getLastName()).isEqualTo(savedClient.getLastName());
        assertThat(result.getEmailAddress()).isEqualTo(savedClient.getEmailAddress());
        assertThat(result.getPhoneNumber()).isEqualTo(savedClient.getPhoneNumber());

        // This will verify the exact values passed into the repository.save()
        ArgumentCaptor<Clients> clientCaptor = ArgumentCaptor.forClass(Clients.class);
        verify(clientsRepository).save(clientCaptor.capture());

        Clients capturedClient = clientCaptor.getValue();
        assertThat(capturedClient.getFirstName()).isEqualTo(savedClient.getFirstName());
        assertThat(capturedClient.getLastName()).isEqualTo(savedClient.getLastName());
        assertThat(capturedClient.getEmailAddress()).isEqualTo(savedClient.getEmailAddress());
        assertThat(capturedClient.getPhoneNumber()).isEqualTo(savedClient.getPhoneNumber());

    }

    @Test
    @DisplayName("getClients should return all clients from repository")
    void getClients_ShouldReturnListOfClients() {
        List<Clients> clientsList = List.of(
                Clients.builder().clientId(1L).firstName("John").build(),
                Clients.builder().clientId(2L).firstName("Jane").build());

        when(clientsRepository.findAll()).thenReturn(clientsList);
        List<Clients> result = clientService.getClients();

        assertThat(result).hasSize(2);
        assertThat(result.get(0).getFirstName()).isEqualTo(clientsList.get(0).getFirstName());
        assertThat(result.get(1).getFirstName()).isEqualTo(clientsList.get(1).getFirstName());

        verify(clientsRepository).findAll();
    }

    @Test
    @DisplayName("getClients should return an empty list when no clients exist")
    void getClients_WhenNoClients_ShouldReturnEmptyList() {
        when(clientsRepository.findAll()).thenReturn(Collections.emptyList());
        List<Clients> result = clientService.getClients();

        assertThat(result).isNotNull().isEmpty();

        verify(clientsRepository).findAll();
    }

    @Test
    @DisplayName("getClientById should return client when ID exists")
    void getClientById_WhenExists_ShouldReturnClient() {
        Long clientId = 1L;
        Clients client = Clients.builder()
                .clientId(clientId)
                .firstName("John")
                .lastName("Doe")
                .emailAddress("john.doe@example.com")
                .phoneNumber("123-456-7890")
                .build();

        when(clientsRepository.findById(clientId)).thenReturn(Optional.of(client));

        Clients result = clientService.getClientById(clientId);

        assertThat(result).isNotNull();
        assertThat(result.getClientId()).isEqualTo(clientId);
        assertThat(result.getFirstName()).isEqualTo(client.getFirstName());
        assertThat(result.getLastName()).isEqualTo(client.getLastName());
        assertThat(result.getEmailAddress()).isEqualTo(client.getEmailAddress());
        assertThat(result.getPhoneNumber()).isEqualTo(client.getPhoneNumber());

        verify(clientsRepository).findById(clientId);
    }

    @Test
    @DisplayName("getClientById should throw ClientNotFoundException when ID does not exist")
    void getClientById_WhenClientNotFound_ShouldThrowClientNotFoundException() {
        Long clientId = 99L;
        when(clientsRepository.findById(clientId)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> clientService.getClientById(clientId)).isInstanceOf(ClientNotFoundException.class);

        verify(clientsRepository).findById(clientId);
    }
}