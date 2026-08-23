package com.wiredav.app.controllers;

import com.wiredav.app.dtos.clientDTOs.AddClientRequestDTO;
import com.wiredav.app.dtos.clientDTOs.AddClientResponseDTO;
import com.wiredav.app.dtos.clientDTOs.GetClientsListResponseDTO;
import com.wiredav.app.services.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public AddClientResponseDTO addClient(@RequestBody AddClientRequestDTO request) {
        var createClient = clientService.createClient(request);
        return new AddClientResponseDTO(createClient);
    }

    @GetMapping("/clients")
    public ResponseEntity<GetClientsListResponseDTO> getAllClients() {
        GetClientsListResponseDTO response = clientService.getClients();
        return ResponseEntity.ok(response);
    }
}