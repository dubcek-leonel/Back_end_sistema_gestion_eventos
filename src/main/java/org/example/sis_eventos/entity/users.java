package org.example.sis_eventos.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class users {
    @Id
    private Long id;

    private String email;

}
