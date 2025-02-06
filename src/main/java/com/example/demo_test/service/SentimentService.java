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

    public SentimentService(SentimentRepository sentimentRepository, ClientService clientService) {
        this.sentimentRepository = sentimentRepository;
        this.clientService = clientService;
    }

    public void creer(Sentiment sentiment) {
        Client client = this.clientService.lireOuCreer(sentiment.getClient());
        sentiment.setClient(client);


        if (sentiment.getTexte().contains("pas")){
            sentiment.setType(TypeSentiment.NEGATIF);
        }else {
            sentiment.setType(TypeSentiment.POSITIF);
        }
        this.sentimentRepository.save(sentiment);
    }

    public List<Sentiment> rechercher(TypeSentiment type) {
        if(type == null){
            return this.sentimentRepository.findAll();
        } else {
            return this.sentimentRepository.findByType(type);
        }

    }

    public void supprimer(int id) {
        this.sentimentRepository.deleteById(id);
    }
}
