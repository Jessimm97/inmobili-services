package com.micro.agents.controller;

import com.micro.agents.model.Agent;
import com.micro.agents.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/agents")
public class AgentController {
    @Autowired
    private AgentService agentService;

    @PostMapping
    public ResponseEntity<Agent> create(@RequestBody Agent agent) {
        return ResponseEntity.ok(agentService.createAgent(agent));
    }

    @GetMapping
    public ResponseEntity<List<Agent>> getAll() {
        return ResponseEntity.ok(agentService.getAllAgents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Agent> getById(@PathVariable Long id) {
        Agent agent = agentService.getAgentById(id);
        return agent != null ? ResponseEntity.ok(agent) : ResponseEntity.notFound().build();
    }
}