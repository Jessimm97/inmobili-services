package com.micro.properties.client;

import com.micro.properties.dto.AgentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// "micro-agents" es el nombre con el que se registró el otro servicio en Eureka
@FeignClient(name = "micro-agents") 
public interface AgentClient {

    @GetMapping("/api/v1/agents/{id}")
    AgentDTO getAgentById(@PathVariable("id") Long id);
}