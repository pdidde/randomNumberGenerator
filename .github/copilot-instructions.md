# Copilot Instructions for RandomNumberGenerator

## Project Overview
Spring Boot 3.5.6 REST API application with Java 21 that generates random 4-digit numbers. Includes REST Assured testing framework for API validation.

### Build & Test
```bash
cd randomNumberGenerator
./mvnw clean install      # Build and run tests
./mvnw spring-boot:run    # Start server on port 8080
```

### Architecture
- **Model**: POJO for random number responses
- **Controller**: REST endpoint at `/api/random/generate` returning random 4-digit numbers (1000-9999)
- **Service**: Business logic for number generation
- **Tests**: REST Assured API tests in `src/test/java`

### Key Dependencies
- Spring Boot Web Starter
- REST Assured (io.rest-assured:rest-assured)
- Spring Boot Test Starter

### Development Status
- [ ] Project scaffolded
- [ ] Controller endpoint implemented
- [ ] REST Assured tests created
- [ ] Build successful
