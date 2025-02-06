// Interface ClientRepository couche d'accès pour entité Client pour manipuler les données des clients dans la base

package com.example.demo_test.repository;

import com.example.demo_test.entites.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {

    Client findByEmail(String email); //Chercher les clients dans la BDD sans requête SQL

}
