package com.micro.properties.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "inquiries")
@Data
public class Inquiry {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Datos del Cliente
    private String clientName;
    private String clientEmail;
    private String clientPhone;
    
    @Column(columnDefinition = "TEXT")
    private String message;

    // Relación: ¿Por cuál casa preguntaron?
    @Column(name = "property_id")
    private Long propertyId;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}