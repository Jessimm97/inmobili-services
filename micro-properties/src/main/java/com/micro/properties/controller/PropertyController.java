package com.micro.properties.controller;

import com.micro.properties.model.Property;
import com.micro.properties.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/properties") // Prefijo que configuramos en el Gateway
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    // POST: Crear una casa
    @PostMapping
    public ResponseEntity<Property> createProperty(@RequestBody Property property) {
        return new ResponseEntity<>(propertyService.createProperty(property), HttpStatus.CREATED);
    }

    // GET: Listar todas
    @GetMapping
    public ResponseEntity<List<Property>> getAllProperties() {
        return ResponseEntity.ok(propertyService.getAllProperties());
    }

    // GET: Obtener una por ID
    @GetMapping("/{id}")
    public ResponseEntity<Property> getPropertyById(@PathVariable Long id) {
        Property property = propertyService.getPropertyById(id);
        if (property == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(property);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Property>> searchProperties(
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) Integer minBedrooms,
            @RequestParam(required = false) Double maxPrice
    ) {
        return ResponseEntity.ok(propertyService.searchProperties(keyword, minBedrooms, maxPrice));
    }
}