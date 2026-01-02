# 🏠 Micro-Properties Service

This is the core service of the application. It handles the property inventory, search logic, and initial customer interactions.

## ✨ Features

* **Property Management:** Full CRUD (Create, Read, Update).
* **Advanced Search:** Dynamic filtering by `keyword` (title/location), `minBedrooms`, and `maxPrice`.
* **Agent Integration:** Uses **OpenFeign** to query the `micro-agents` service and enrich the property response with seller details.
* **Inquiries:** Stores contact messages from clients interested in specific properties.

## 🔗 Key Endpoints

### Properties
* `GET /api/v1/properties`: List all properties.
* `GET /api/v1/properties/{id}`: Single property details + Agent Data.
* `GET /api/v1/properties/search`: Search via Query Params.
* `POST /api/v1/properties`: Create a new property.

### Inquiries
* `POST /api/v1/inquiries`: Save a new lead.

## ⚙️ Configuration

Requires a **PostgreSQL** instance. Credentials are configured in `application.yml` or environment variables:

```yaml
spring:
  datasource:
    url: jdbc:postgresql://postgres-db:5432/immobili_db
    username: admin
    password: password123