package com.wiredav.app.controllers;

import com.wiredav.app.dtos.clientDTOs.AddClientRequestDTO;
import com.wiredav.app.dtos.clientDTOs.AddClientResponseDTO;
import com.wiredav.app.dtos.clientDTOs.GetClientResponseDTO;
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

    @PostMapping("/addClient")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<AddClientResponseDTO> addClient(@RequestBody AddClientRequestDTO request) {
        var createClient = clientService.createClient(request);
        return ResponseEntity.ok().body(createClient.toAddClientResponseDTO());
    }

    @GetMapping("/clients")
    public ResponseEntity<GetClientsListResponseDTO> getAllClients() {
        GetClientsListResponseDTO response = clientService.getClients();
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/clients/{id}")
    public ResponseEntity<GetClientResponseDTO> getClientById(@PathVariable Long id) {
        var response = clientService.getClientById(id);
        return ResponseEntity.ok(new GetClientResponseDTO(response));
    }
}