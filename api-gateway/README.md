# API Gateway

API Gateway for the **Enterprise Order & Workflow Management System (EOWM)**.

---

## Overview
The API Gateway acts as a **single entry point** for all backend microservices.
It routes incoming requests to the appropriate services and simplifies access
for frontend applications.

---

## Responsibilities
- Centralized routing for backend services
- Single entry point for frontend (React)
- Path-based routing with prefix stripping
- Prepared for cross-cutting concerns (security, logging, rate limiting)

---

## Architecture
Client (React)
|
API Gateway (8080)
|

| Auth | Order | Workflow |
| 8081 | 8082 | 8083 |

---

## Routes Configuration

| External Path | Target Service | Internal Path |
|--------------|---------------|---------------|
| `/auth/**` | Auth Service | `/api/auth/**` |
| `/orders/**` | Order Service | `/api/orders/**` |
| `/workflows/**` | Workflow Service | `/api/workflows/**` |

---

## Technology Stack
- Java 17
- Spring Boot
- Spring Cloud Gateway (Reactive)
- Spring Security
- Maven

---

## How Routing Works
- Requests are matched using path predicates
- `StripPrefix=1` removes external path prefixes
- Requests are forwarded to the appropriate microservice

Example:

POST /orders -> Order Service /api/orders

---

## Security Design
- Gateway currently performs **routing only**
- JWT validation is handled by individual microservices
- Gateway is prepared for centralized authentication in future

---

## How to Run
```bash
./mvnw spring-boot:run