// Interface SentimentRepository couche d'accès pour entité Sentiment
package com.example.demo_test.repository;

import com.example.demo_test.entites.Sentiment;
import com.example.demo_test.enums.TypeSentiment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SentimentRepository extends JpaRepository<Sentiment, Integer> {
    List<Sentiment> findByType(TypeSentiment type); // Chercher les types de sentiment
}
