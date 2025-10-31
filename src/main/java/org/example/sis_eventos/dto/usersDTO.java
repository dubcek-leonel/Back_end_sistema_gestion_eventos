package org.example.sis_eventos.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class usersDTO {

    private Long id;
    @Column(nullable = false)
    @Size(min = 1, max = 50)
    @NotBlank

    private String nombre;
    @Column(nullable = false)
    @Size(min = 1, max = 50)
    @NotBlank
    private String email;

    @Column(nullable = false)
    @NotNull
    @Size(min = 1, max = 50)
    private String studentCode;

    private String fullName;
    @Column(nullable = false)
    

    private String role;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String career;

    @Column(nullable = false)
    private String semmester;
    private String profileImage;
    private boolean isActive;

}
