# Advanced Microservice Gateway Architecture

Welcome to the full-stack microservice integration project! This repository contains a three-piece Spring Boot microservice architecture (Artist employee management, Poster inventory management, and a Gateway Nexus overlay), alongside a fully integrated Angular 17 interface.

## Architecture Highlights
- **Microservice 1 (Artist)**: Internal service bound to `localhost:8081`. Governs the initial records of Employees to the H2 database.
- **Microservice 2 (Poster)**: Internal service bound to `localhost:8082`. Governs Item generation directly tying Item availability and Sales logic to the `H2` memory instance.
- **Gateway**: The focal proxy server on `localhost:8080`. Resolves UI requests gracefully via `RestTemplate` overriding dependencies dynamically. Includes an independent endpoint resolving safe proxy adjustments for "Quantity Purchasing" without mutating the internal Microservice codebase!
- **Frontend (Angular)**: Found internally inside `/src/main/webapp/`.

## Running the Application
### Backend Sequence (Java/Spring Boot)
Launch the microservices via Eclipse or with Maven `spring-boot:run`:
1. Start `FINAL_MICRO1_Janasi_Rajput`
2. Start `FINAL_MICRO2_Janasi_Rajput`
3. Start `FINAL_GATEWAY_Janasi_Rajput`

### Frontend Sequence (Node/Angular)
From the root directory of the Gateway `webapp` folder:
```bash
cd FINAL_GATEWAY_Janasi_Rajput/src/main/webapp
npm install
npm run start
```
This automatically establishes a proxy mapping resolving `/api/v1` routes straight cleanly into the Java application. 

### Visual Features
- **Glassmorphism Design**: Dark mode aesthetic utilizing modern gradient layouts.
- **Dynamic Action Validation**: Purchasing items dynamically disables upon reaching "SOLD OUT".

Have fun exploring the application capabilities!
