# 🕵️‍♂️ Micro-Agents Service

Service responsible for managing real estate agent information. It acts as the single source of truth for seller profiles.

## 🎯 Responsibility

Provides detailed information (Name, Email, Phone, Photo) of agents to other microservices, primarily to `micro-properties`.

## 🔗 Endpoints

* `GET /api/v1/agents`: List all agents.
* `GET /api/v1/agents/{id}`: Get a specific agent profile.
* `POST /api/v1/agents`: Register a new agent.

## 🛠️ Technical Details

* Database: PostgreSQL (Shares the instance but uses independent tables).
* Default Port: `8082`.