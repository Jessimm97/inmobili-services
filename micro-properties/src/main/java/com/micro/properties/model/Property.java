package com.micro.properties.model;

import com.micro.properties.dto.AgentDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor; 
import lombok.Data;
import lombok.NoArgsConstructor;  
import java.time.LocalDateTime;
import java.util.ArrayList; 
import java.util.List;

@Entity
@Table(name = "properties")
@Data
@NoArgsConstructor  // OBLIGATORIO para JPA
@AllArgsConstructor // Útil
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String location;
    private String price;
    
    @Column(columnDefinition = "TEXT")
    private String description;
    
    private int bedrooms;
    private int bathrooms;
    private int stories;
    
    @Column(name = "image_url")
    private String img;

    @Column(name = "agent_id")
    private Long agentId;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @ElementCollection
    @CollectionTable(
        name = "property_features", 
        joinColumns = @JoinColumn(name = "property_id")
    )
    @Column(name = "feature")
    private List<String> features = new ArrayList<>();

    @Transient 
    private AgentDTO agentData;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}