package org.example.sis_eventos.dto;

import lombok.Data;
import java.util.Date;

@Data
public class RegistrationDTO {

    private Long id;
    private Long eventId;
    private Long userId;
    private String status;
    private String registrationType;
    private String notes;
    private Long approvedBy;
    private Date approvedAt;
    private Date createdAt;
    private Date updatedAt;
}
