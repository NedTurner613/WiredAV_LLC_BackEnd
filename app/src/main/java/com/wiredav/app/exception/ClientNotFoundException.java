package com.wiredav.app.exception;

public class ClientNotFoundException extends RuntimeException {
    public ClientNotFoundException(Long clientId) {
        super("Client with id " + clientId + " not found");
    }
}