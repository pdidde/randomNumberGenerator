# Random Number Generator API

A Spring Boot REST API that generates random 4-digit numbers (1000-9999).

## Features
- Endpoint: `GET /api/random/generate` returns a random 4-digit number and timestamp
- Java 21, Spring Boot 3.5.6
- REST Assured tests for API validation

## Build & Run
```bash
./mvnw clean install      # Build and run tests
./mvnw spring-boot:run    # Start server on port 8080
```

## API Example
```
GET http://localhost:8080/api/random/generate

Response:
{
  "random_number": 1234,
  "generated_at": 1706280000000
}
```

## Test
```bash
./mvnw test
```

---

See `.github/copilot-instructions.md` for AI agent guidance.
