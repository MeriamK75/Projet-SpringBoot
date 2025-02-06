package com.example.demo_test.controller;

import com.example.demo_test.dto.ClientDTO;
import com.example.demo_test.dto.ErrorEntity;
import com.example.demo_test.entites.Client;
import com.example.demo_test.service.ClientService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.stream.Stream;

@RestController // Gère des requêtes HTTPS
@RequestMapping(path = "client")

public class ClientController {
    private final ClientService clientService;

    // Constructeur
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @ResponseStatus(value = HttpStatus.CREATED) // CODE 201 "SUCCESSFUL" --> "Created"
    @PostMapping(consumes = "application/json")
    public void creer(@RequestBody Client client){
        this.clientService.creer(client);
    }

    @GetMapping(produces = "application/json")
    public Stream<ClientDTO> rechercher() {
        return this.clientService.rechercher();
    }

    @GetMapping(path = "{id}", produces = "application/json")
    public ResponseEntity lire(@PathVariable int id) {
        try {
            Client client = this.clientService.lire(id);
            return ResponseEntity.ok(client);
        } catch (EntityNotFoundException exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorEntity(null, exception.getMessage()));
        }

    }

    @ResponseStatus(HttpStatus.NO_CONTENT) // CODE 204 "SUCCESSFUL" --> "No Content"
    @PutMapping(path = "{id}", consumes = "application/json" )
    public void modifier(@PathVariable int id,@RequestBody Client client){
        this.clientService.modifier(id, client);
    }

}


