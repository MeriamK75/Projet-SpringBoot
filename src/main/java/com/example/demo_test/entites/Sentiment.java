package com.example.demo_test.entites;

import com.example.demo_test.enums.TypeSentiment;
import jakarta.persistence.*;

@Entity
@Table(name = "SENTIMENT") // Fait référence à la BDD

public class Sentiment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //id généré automatiquement par la BDD
    private int id;
    private String texte;
    private TypeSentiment type;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}) // Un client peut avoir plusieurs sentiments (si un sentiment est mis à jour le client aussi le sera)
    @JoinColumn(name = "CLIENT_ID")
    private Client client;

    public Sentiment() {
    }

    //Constructeur
    public Sentiment(int id, String texte, TypeSentiment type, Client client) {
        this.id = id;
        this.texte = texte;
        this.type = type;
        this.client = client;
    }

    // Méthode GET et SET
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public TypeSentiment getType() {
        return type;
    }

    public void setType(TypeSentiment type) {
        this.type = type;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }
}
