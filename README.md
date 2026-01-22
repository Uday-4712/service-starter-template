# Sugarfit Java Service Starter Template

Minimal Spring Boot service implementing the assignment requirements.

## How to run
- Prereqs: Java 17+, Maven (or use `./mvnw`).
- Build: `./mvnw clean package`
- Run: `./mvnw spring-boot:run`
- Test: `./mvnw test`

## Endpoints
- `GET /health` — returns application status.
- `POST /example`
  - Request: `{ "userId": "123", "value": 42 }`
  - Response: `{ "status": "SUCCESS", "requestId": "uuid-string" }`

## Design decisions
- Layered structure (`controller`, `service`, `dto`) to keep HTTP, business logic, and payloads separated.
- Jakarta Bean Validation on inputs with a `@RestControllerAdvice` to return consistent error envelopes.
- Actuator dependency included for operational readiness (e.g., health/metrics expansion later).
- UUID per request for traceability in responses; logic intentionally minimal for a starter template.

## Assumptions
- No persistence, caching, or authentication required for the sample endpoints.
- Minimal business logic is acceptable; focus is on scaffolding and conventions.
- Local run with default Spring profile is sufficient; no external dependencies needed.

## Future roadmap
- Add OpenAPI/Swagger docs and CI checks (lint, tests).
- Add structured logging, metrics, and request tracing configuration.
- Introduce persistence and authentication once real business logic arrives.
- Harden error model and add integration tests hitting the HTTP layer.

