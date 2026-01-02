# 🌐 API Gateway (Spring Cloud Gateway)

Single entry point for the microservices architecture.

## 🚀 Functions

1.  **Routing:** Redirects frontend requests to the corresponding microservices.
    * `/api/v1/properties/**` -> `MICRO-PROPERTIES`
    * `/api/v1/inquiries/**` -> `MICRO-PROPERTIES`
    * `/api/v1/agents/**` -> `MICRO-AGENTS`
2.  **Load Balancing:** Distributes traffic if multiple instances of a service exist.
3.  **CORS:** Manages security policies to allow requests from the Frontend (`http://localhost:3000`).

## ⚙️ Key Configuration

Routing uses `lb://SERVICE-NAME` to dynamically resolve addresses via Eureka.