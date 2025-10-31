package org.example.sis_eventos.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "payments")
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Generación IDENTITY para Long
    private Long id;

    @NotNull(message = "El ID de registro no puede ser nulo")
    @Column(name = "registration_id", nullable = false)
    private Long registrationId;

    @NotNull(message = "El monto no puede ser nulo")
    @DecimalMin(value = "0.01", message = "El monto debe ser positivo")
    @Column(name = "amount", precision = 10, scale = 2, nullable = false)
    private BigDecimal amount;

    @NotNull(message = "La moneda no puede ser nula")
    @Size(min = 3, max = 3, message = "La moneda debe tener 3 caracteres (e.g., USD)")
    @Column(name = "currency", length = 3, nullable = false)
    private String currency;

    @Size(max = 50, message = "El método de pago no debe exceder los 50 caracteres")
    @Column(name = "payment_method")
    private String paymentMethod;

    @Size(max = 20, message = "El estado de pago no debe exceder los 20 caracteres")
    @Column(name = "payment_status")
    private String paymentStatus;

    @Size(max = 100, message = "La referencia de la transacción no debe exceder los 100 caracteres")
    @Column(name = "transaction_reference")
    private String transactionReference;

    @Column(name = "payment_proof_url")
    private String paymentProofUrl;

    @Column(name = "verified_by")
    private Long verifiedBy;

    @Column(name = "verified_at")
    private Date verifiedAt;

    @Column(name = "notes")
    private String notes;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Date fechaCreacion;

    @Column(name = "updated_at", nullable = false)
    private Date fechaModificacion;

    // Métodos de ciclo de vida
    @PrePersist
    public void prePersist() {
        Date now = new Date();
        this.fechaCreacion = now;
        this.fechaModificacion = now;
    }

    @PreUpdate
    public void preUpdate() {
        this.fechaModificacion = new Date();
    }
}