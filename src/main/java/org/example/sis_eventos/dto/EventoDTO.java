package org.example.sis_eventos.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

public class EventoDTO {

    private Long id;
    private String title;
    private String description;
    private String type;
    private String location;
    private String organizer;
    private Integer maxCapacity;
    private Integer currentRegistrations;
    private Boolean isPaid;
    private BigDecimal price;
    private String currency;
    private Boolean requiresApproval;
    private Boolean isPublished;
    private String status;
    private String imageUrl;
    private Date registrationDeadline;
    private String createdBy;
    private Date fechaCreacion;
    private Date fechaModificacion;

    // 🔹 Constructor vacío
    public EventoDTO() {}

    // 🔹 Constructor completo
    public EventoDTO(long id, String title, String description, String type, String location, String organizer,
                     Integer maxCapacity, Integer currentRegistrations, Boolean isPaid, BigDecimal price,
                     String currency, Boolean requiresApproval, Boolean isPublished, String status, String imageUrl,
                     Date registrationDeadline, String createdBy, Date fechaCreacion, Date fechaModificacion) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.type = type;
        this.location = location;
        this.organizer = organizer;
        this.maxCapacity = maxCapacity;
        this.currentRegistrations = currentRegistrations;
        this.isPaid = isPaid;
        this.price = price;
        this.currency = currency;
        this.requiresApproval = requiresApproval;
        this.isPublished = isPublished;
        this.status = status;
        this.imageUrl = imageUrl;
        this.registrationDeadline = registrationDeadline;
        this.createdBy = createdBy;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
    }

    // 🔹 Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    public Integer getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(Integer maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public Integer getCurrentRegistrations() {
        return currentRegistrations;
    }

    public void setCurrentRegistrations(Integer currentRegistrations) {
        this.currentRegistrations = currentRegistrations;
    }

    public Boolean getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(Boolean isPaid) {
        this.isPaid = isPaid;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Boolean getRequiresApproval() {
        return requiresApproval;
    }

    public void setRequiresApproval(Boolean requiresApproval) {
        this.requiresApproval = requiresApproval;
    }

    public Boolean getIsPublished() {
        return isPublished;
    }

    public void setIsPublished(Boolean isPublished) {
        this.isPublished = isPublished;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Date getRegistrationDeadline() {
        return registrationDeadline;
    }

    public void setRegistrationDeadline(Date registrationDeadline) {
        this.registrationDeadline = registrationDeadline;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }
}
