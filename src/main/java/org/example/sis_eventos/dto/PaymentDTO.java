package org.example.sis_eventos.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class PaymentDTO {

    private Long id;
    private Long registrationId;
    private BigDecimal amount;
    private String currency;
    private String paymentMethod;
    private String paymentStatus;
    private String transactionReference;
    private String paymentProofUrl;
    private Long verifiedBy;
    private Date verifiedAt;
    private String notes;

    private Date createdAt;
    private Date updatedAt;

}