package com.example.demo_test.service;

import com.example.demo_test.dto.ClientDTO;
import com.example.demo_test.entites.Client;
import com.example.demo_test.mapper.ClientDTOMapper;
import com.example.demo_test.repository.ClientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;
import java.util.stream.Stream;

@Service
public class ClientService {
    private final ClientDTOMapper clientDTOMapper;

    private final ClientRepository clientRepository;

    // Constructeur
    public ClientService(ClientDTOMapper clientDTOMapper, ClientRepository clientRepository) {
        this.clientDTOMapper = clientDTOMapper;
        this.clientRepository = clientRepository;
    }

    // Fonction qui crée un client
    public void creer(Client client){
        Client clientDansLaBDD = this.clientRepository.findByEmail(client.getEmail());
        if(clientDansLaBDD == null) {
            this.clientRepository.save(client);
        }
    }

    //
    public Stream<ClientDTO> rechercher() {
        return this.clientRepository.findAll()
                .stream().map(clientDTOMapper);

    }

    // Fonction qui permet de récupérer un client par son id
    public Client lire(int id) {
        Optional<Client> optionalClient = this.clientRepository.findById(id);
        return optionalClient.orElseThrow(
                () -> new EntityNotFoundException("Aucun client n'existe avec cet ID")
        );
    }

    // Fonction qui permet de lire un client dans la BDD. Si le client n'existe pas, on le crée
    public Client lireOuCreer(Client clientAcreer){
        Client clientDansLaBDD = this.clientRepository.findByEmail(clientAcreer.getEmail());
        if(clientDansLaBDD == null) {
            clientDansLaBDD = this.clientRepository.save(clientAcreer);
        }
        return clientDansLaBDD;
    }

    // Fonction qui permet de modifier les informations d'un client
    public void modifier(int id, Client client) {
        Client clientDansLaBDD = this.lire(id);
        if(clientDansLaBDD.getId() == client.getId()){
            clientDansLaBDD.setEmail(client.getEmail());
            clientDansLaBDD.setTelephone(client.getTelephone());
            this.clientRepository.save(clientDansLaBDD);
        }
    }
}
