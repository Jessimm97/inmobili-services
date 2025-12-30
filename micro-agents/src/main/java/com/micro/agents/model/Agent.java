package com.micro.agents.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "agents")
@Data
public class Agent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phone;
    private String photoUrl;
}