package com.example.demo_test.mapper;

import com.example.demo_test.dto.ClientDTO;
import com.example.demo_test.entites.Client;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ClientDTOMapper implements Function<Client, ClientDTO> {
    @Override
    public ClientDTO apply(Client client) {
        return new ClientDTO(client.getId(), client.getEmail(), client.getTelephone());
    }
}
