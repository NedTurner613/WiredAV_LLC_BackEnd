package com.wiredav.app.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wiredav.app.dtos.clientDTOs.AddClientRequestDTO;
import com.wiredav.app.dtos.clientDTOs.AddClientResponseDTO;
import com.wiredav.app.dtos.clientDTOs.GetClientResponseDTO;
import com.wiredav.app.dtos.clientDTOs.GetClientsListResponseDTO;
import com.wiredav.app.entities.Clients;
import com.wiredav.app.services.ClientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(controllers = ClientController.class)
@AutoConfigureMockMvc(addFilters = false)
class ClientControllerTest {
    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper = new ObjectMapper();

    @MockitoBean
    private ClientService clientService;


    @Test
    @DisplayName("POST /api/v1/clients/addClient - should return 201 Created when client is created")
    void addClient_returnsCreatedStatusAndBody() throws Exception {
        AddClientRequestDTO request = new AddClientRequestDTO("John", "Doe", "john.doe@example.com", "123-123-1234");
        var clientMock = org.mockito.Mockito.mock(Clients.class);
        AddClientResponseDTO expectedResponse = new AddClientResponseDTO(1L, "John", "Doe", "john.doe@example.com", "123-123-1234");

        when(clientService.createClient(any(AddClientRequestDTO.class))).thenReturn(expectedResponse);
        when(clientMock.toAddClientResponseDTO()).thenReturn(expectedResponse);

        mockMvc.perform(post("/api/v1/clients/addClient")
                        .with(csrf())
                        .with(user("admin"))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect((ResultMatcher) jsonPath("$.clientId").value(1L))
                .andExpect((ResultMatcher) jsonPath("$.firstName").value("John"));

        verify(clientService).createClient(any(AddClientRequestDTO.class));
    }

//    @Test
//    @DisplayName("GET /api/v1/clients - should return 200 OK with list of clients")
//    void getAllClients_ShouldReturnOkWithClientLists() throws Exception {
//        List<Clients> clients = List.of(
//                new Clients("Alice", "Wonderland", "123-123-1234", "alice.wonderland@example.com"),
//                new Clients("Roger", "Rabbit", "123-123-1234", "roger.rabbit@example.com"));
//
//        Page<GetClientsListResponseDTO> clientsPage = new PageImpl<>(clients);
//
//        when(clientService.getClients(any(Pageable.class))).thenReturn(clientsPage);
//
//        mockMvc.perform(get("/api/v1/clients"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.content.length()").value(clients.size()));
//
//        verify(clientService).getClients(Pageable.ofSize(5));
//    }

    @Test
    @WithMockUser
    @DisplayName("GET /api/v1/clients/{id} - should return 200 OK when client exists")
    void getClientById_ShouldReturnOk() throws Exception {
        Long clientId = 1L;
        var clientMock = org.mockito.Mockito.mock(Clients.class);
        GetClientResponseDTO expectResponse = new GetClientResponseDTO(clientId, "Alice", "Wonderland", "alice.wonderland@example.com", "123-123-1234");

        when(clientService.getClientById(clientId)).thenReturn(expectResponse);
        when(clientMock.toGetClientByIdResponseDTO()).thenReturn(expectResponse);

        mockMvc.perform(get("/api/v1/clients/{id}", clientId))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$.clientId").value(clientId))
                .andExpect((ResultMatcher) jsonPath("$.firstName").value("Alice"));

        verify(clientService).getClientById(clientId);
    }
}