# Workflow Service

Workflow management microservice for the **Enterprise Order & Workflow Management System (EOWM)**.

---

## Overview
The Workflow Service is responsible for handling **business process workflows** related to orders.
It manages approval and rejection actions and maintains a complete workflow history, independent of the Order Service.

This service enforces **role-based access control** and validates JWT tokens independently.

---

## Responsibilities
- Approve orders (ADMIN, MANAGER)
- Reject orders (ADMIN, MANAGER)
- Maintain workflow action history
- Provide workflow history for an order
- Enforce role-based authorization using JWT

---

## Architecture Principles
- **Separation of concerns**: Workflow logic is isolated from order data
- **Loose coupling**: No database foreign keys to Order Service
- **Stateless security**: JWT validated inside the service
- **Microservice autonomy**: Own database and domain model

---

## Tech Stack
- Java 17
- Spring Boot
- Spring Security
- JWT (HMAC SHA)
- Spring Data JPA
- PostgreSQL
- Maven

---

## API Endpoints

### Approve Order
POST /api/workflows/approve

**Roles:** ADMIN, MANAGER

### Reject Order
POST /api/workflows/reject

**Roles:** ADMIN, MANAGER

### Get Workflow History
GET /api/workflows/{orderId}

*Roles:** ADMIN, MANAGER, USER

---

## API Documentation (Swagger)

Swagger UI:
http://localhost:8083/swagger-ui/index.html

OpenAPI Specification:
http://localhost:8083/v3/api-docs

---

## Security
- Stateless JWT authentication
- Token validated independently of other services
- Role-based authorization using method-level security
- JWT must be passed via `Authorization` header

Example:
Authorization: Bearer <jwt-token>

---

## Database
- Database: `workflow_db`
- Table: `workflow_actions`
- Stores workflow actions without cross-service foreign keys

---

## How to Run
```bash
./mvnw spring-boot:run
