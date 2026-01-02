package com.micro.properties.service;

import com.micro.properties.client.AgentClient;
import com.micro.properties.dto.AgentDTO;
import com.micro.properties.model.Property;
import com.micro.properties.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    // --- CORRECCIÓN 1: INYECTAR EL CLIENTE ---
    @Autowired
    private AgentClient agentClient; 
    // -----------------------------------------

    public Property createProperty(Property property) {
        return propertyRepository.save(property);
    }

    public List<Property> getAllProperties() {
        List<Property> properties = propertyRepository.findAll();
        // Llenar datos de agentes para todas las propiedades
        properties.forEach(this::fetchAgentData);
        return properties;
    }

    public Property getPropertyById(Long id) {
        Property property = propertyRepository.findById(id).orElse(null);
        if (property != null) {
            fetchAgentData(property);
        }
        return property;
    }

    public List<Property> searchProperties(String keyword, Integer minBedrooms, Double maxPrice) {
        List<Property> properties = propertyRepository.searchProperties(keyword, minBedrooms, maxPrice);
        // Llenar datos de agentes para los resultados de búsqueda
        properties.forEach(this::fetchAgentData);
        return properties;
    }

    // Método auxiliar para no repetir código (DRY)
    private void fetchAgentData(Property prop) {
        if (prop.getAgentId() != null) {
            try {
                AgentDTO agent = agentClient.getAgentById(prop.getAgentId());
                // CORRECCIÓN 2: Esto funcionará cuando arreglemos el Modelo en el Paso 2
                prop.setAgentData(agent); 
            } catch (Exception e) {
                // Si falla micro-agents, seguimos sin romper nada
            }
        }
    }
}