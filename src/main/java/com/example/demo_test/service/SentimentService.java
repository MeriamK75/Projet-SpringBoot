package com.example.demo_test.service;

import com.example.demo_test.entites.Client;
import com.example.demo_test.entites.Sentiment;
import com.example.demo_test.enums.TypeSentiment;
import com.example.demo_test.repository.SentimentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SentimentService {

    private ClientService clientService;
    private SentimentRepository sentimentRepository;

    // Constructeur
    public SentimentService(SentimentRepository sentimentRepository, ClientService clientService) {
        this.sentimentRepository = sentimentRepository;
        this.clientService = clientService;
    }

    // Fonction pour créer un sentiment
    public void creer(Sentiment sentiment) {
        Client client = this.clientService.lireOuCreer(sentiment.getClient());
        sentiment.setClient(client);

    // Si le message contient "pas", le sentiment est négatif
        if (sentiment.getTexte().contains("pas")){
            sentiment.setType(TypeSentiment.NEGATIF);
        }else {
            sentiment.setType(TypeSentiment.POSITIF);
        }
        this.sentimentRepository.save(sentiment); // sentiment sauvegardé dans la BDD
    }

    // Fonction qui affiche les sentiments en filtrant le type
    public List<Sentiment> rechercher(TypeSentiment type) {
        if(type == null){ // Si le type est null ça affiche tout
            return this.sentimentRepository.findAll();
        } else {
            return this.sentimentRepository.findByType(type); // Sinon ça filtre selon le sentiment choisi
        }

    }

    // Fonction qui supprime le sentiment selon l'id qu'on choisit
    public void supprimer(int id) {
        this.sentimentRepository.deleteById(id);
    }
}
