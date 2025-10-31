package org.example.sis_eventos.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@NoArgsConstructor
@Table(name ="users")
@Getter
@Setter
public class UsersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


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
