package com.wiredav.app.controllers;

import com.wiredav.app.dtos.clientDTOs.AddClientRequestDTO;
import com.wiredav.app.dtos.clientDTOs.AddClientResponseDTO;
import com.wiredav.app.dtos.clientDTOs.GetClientResponseDTO;
import com.wiredav.app.dtos.clientDTOs.GetClientsListResponseDTO;
import com.wiredav.app.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;


    @GetMapping("/clients")
    public ResponseEntity<GetClientsListResponseDTO> GetClients(){
        GetClientsListResponseDTO clientsList = clientService.GetClients();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(clientsList);
    }

    @GetMapping("/client/{id}")
    public ResponseEntity<GetClientResponseDTO> GetClient(@PathVariable("id") Long id){
        GetClientResponseDTO clientInfo = clientService.GetClient(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(clientInfo);
    }

    @PostMapping("/client")
    public ResponseEntity<AddClientResponseDTO> AddClient(@RequestBody AddClientRequestDTO newClient){
        AddClientResponseDTO createdClient = clientService.AddClient(newClient);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(createdClient);
    }
}
