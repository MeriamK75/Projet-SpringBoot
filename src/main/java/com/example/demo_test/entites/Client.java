package com.example.demo_test.entites;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "CLIENT")
public class Client {
    @Id // cle primaire
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String telephone;
    private Date creation;
    @Column(name = "mis_a_jour" )
    private Date misAJour;


    public Client() {
    }

    public Client(int id, String email, String telephone, Date creation, Date misAJour) {
        this.id = id;
        this.email = email;
        this.telephone = telephone;
        this.creation = creation;
        this.misAJour = misAJour;
    }

    // Methodes pour lire et definir les données id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

// Méthodes pour lire et définir les données email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Méthodes pour lire et définir les données telephone
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }


    // Méthodes pour lire et définir les dates création
    public Date getCreation() {
        return creation;
    }

    public void setCreation(Date creation) {
        this.creation = creation;
    }

    // Méthodes pour lire et définir les dates mis à jour
    public Date getMisAJour() {
        return misAJour;
    }

    public void setMisAJour(Date misAJour) {
        this.misAJour = misAJour;
    }
}
