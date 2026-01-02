# Order Service

Order management microservice for the Enterprise Order & Workflow Management System (EOWM).

---

## Overview
The Order Service handles core business functionality related to order creation and retrieval.
It enforces role-based access control using JWT authentication.

---

## Responsibilities
- Create orders (ADMIN, MANAGER)
- View orders (ADMIN, MANAGER, USER)
- Enforce role-based authorization
- Validate JWT tokens independently

---

## Tech Stack
- Java 17
- Spring Boot
- Spring Security
- JWT
- PostgreSQL
- Maven

---

## API Endpoints
- POST /api/orders
- GET /api/orders

---

## API Documentation (Swagger)

Swagger UI:
http://localhost:8082/swagger-ui/index.html

OpenAPI Spec:
http://localhost:8082/v3/api-docs

---

## Security
- Stateless JWT authentication
- Role-based access using method-level security
- Token validated independently from Auth Service

---

## How to Run
```bash
./mvnw spring-boot:run
