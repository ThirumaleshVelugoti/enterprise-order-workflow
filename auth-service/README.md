# Auth Service

Authentication and authorization microservice for the Enterprise Order & Workflow Management System (EOWM).

---

## Overview
The Auth Service is responsible for user registration, login, and JWT-based authentication. It provides stateless 
security that can be used by other microservices in the system.

---

## Responsibilities
- User registration
- User login
- JWT token generation and validation
- Role-based authorization (ADMIN, MANAGER, USER)

---

## Tech Stack
- Java 17
- Spring Boot
- Spring Security
- JWT (HMAC SHA-256)
- PostgreSQL
- Maven

---

## Security
- Stateless JWT authentication
- BCrypt password hashing
- Role-based access control

---

## API Endpoints
- `POST /api/auth/register`
- `POST /api/auth/login`

---

## API Documentation (Swagger)

Swagger UI:
http://localhost:8081/swagger-ui/index.html

OpenAPI Spec:
http://localhost:8081/v3/api-docs

### Security Notes
- Swagger UI is open in development environment.
- Secured endpoints require JWT authentication.
- JWT must be passed via `Authorization` header.

---

## How to Run
```bash
./mvnw spring-boot:run
