package com.wiredav.app.controllers;

import com.wiredav.app.dtos.clientDTOs.AddClientRequestDTO;
import com.wiredav.app.dtos.clientDTOs.AddClientResponseDTO;
import com.wiredav.app.dtos.clientDTOs.GetClientResponseDTO;
import com.wiredav.app.dtos.clientDTOs.GetClientsListResponseDTO;
import com.wiredav.app.entities.Clients;
import com.wiredav.app.services.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/addClient")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<AddClientResponseDTO> addClient(@RequestBody AddClientRequestDTO request) {
        var createClient = clientService.createClient(request);
        return ResponseEntity.ok().body(createClient.toAddClientResponseDTO());
    }

    @GetMapping()
    public ResponseEntity<GetClientsListResponseDTO> getAllClients() {
        List<Clients> clients = clientService.getClients();
        GetClientsListResponseDTO response = new GetClientsListResponseDTO(clients);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetClientResponseDTO> getClientById(@PathVariable Long id) {
        var response = clientService.getClientById(id);
        return ResponseEntity.ok().body(response.toGetClientByIdResponseDTO());
    }
}