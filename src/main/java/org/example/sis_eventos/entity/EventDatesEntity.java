package org.example.sis_eventos.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@NoArgsConstructor
@Setter
@Getter
public class EventDatesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date starDate;
    private Date endDate;

    boolean isActive;

    private Date createdAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = new Date();
    }
}
