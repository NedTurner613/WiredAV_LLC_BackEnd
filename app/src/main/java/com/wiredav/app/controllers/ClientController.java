package com.wiredav.app.controllers;

import com.wiredav.app.dtos.clientDTOs.AddClientRequestDTO;
import com.wiredav.app.dtos.clientDTOs.AddClientResponseDTO;
import com.wiredav.app.dtos.clientDTOs.GetClientResponseDTO;
import com.wiredav.app.dtos.clientDTOs.GetClientsListResponseDTO;
import com.wiredav.app.entities.Clients;
import com.wiredav.app.services.ClientService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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
    public AddClientResponseDTO addClient(@Valid @RequestBody AddClientRequestDTO request) {
        return clientService.createClient(request);
    }

    @GetMapping()
    public ResponseEntity<Page<GetClientResponseDTO>> getAllClients(
            @PageableDefault(size = 10, sort = "clientId", direction = Sort.Direction.DESC) Pageable pageable) {
        return ResponseEntity.ok(clientService.getClients(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetClientResponseDTO> getClientById(@PathVariable Long id) {
        var response = clientService.getClientById(id);
        return ResponseEntity.ok(response);
    }
}