// Record permet de représenter une erreur sous forme d'objet
package com.example.demo_test.dto;

public record ErrorEntity(
        String code,
        String message
) {

}
