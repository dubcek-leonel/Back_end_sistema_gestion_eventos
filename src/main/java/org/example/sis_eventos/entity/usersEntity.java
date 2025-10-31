package org.example.sis_eventos.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class users {
    @Id
    private Long id;

    private String nombre;
    private String email;

    private String studentCode;
    private String fullName;
    private String role;
    private String phone;
    private String career;
    private String semmester;
    private String profileImage;
    private boolean isActive;

    @Column(nullable = false)
    private Date createdAt;

    @Column(nullable = false)
    private Date modifiedAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = new Date();
        this.modifiedAt = new Date();
    }
    @PreUpdate
    public void preUpdate() {
        this.modifiedAt = new Date();
    }
}
