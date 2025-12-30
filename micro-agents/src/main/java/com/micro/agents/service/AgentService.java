package com.micro.agents.service;

import com.micro.agents.model.Agent;
import com.micro.agents.repository.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AgentService {
    @Autowired
    private AgentRepository agentRepository;

    public Agent createAgent(Agent agent) {
        return agentRepository.save(agent);
    }

    public List<Agent> getAllAgents() {
        return agentRepository.findAll();
    }

    public Agent getAgentById(Long id) {
        return agentRepository.findById(id).orElse(null);
    }
}