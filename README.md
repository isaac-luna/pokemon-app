# **Pokémon API Application**

## **Overview**
The Pokémon API application is a Spring Boot-based application that interacts with the PokeAPI to provide detailed Pokémon information, abilities, and held items. This project implements REST and SOAP services and includes extensive testing and documentation support.

---

## **Features**
1. **RESTful Endpoints**:
   - Fetch Pokémon details by name or ID.
   - Retrieve Pokémon abilities.
   - Get a list of held items for a specific Pokémon.

2. **SOAP Web Services**:
   - SOAP endpoints for Pokémon details, abilities, and held items.

3. **Interactive API Documentation**:
   - Integrated with **Springdoc OpenAPI** to provide interactive Swagger UI.

4. **Testing**:
   - Unit tests for REST and SOAP services.
   - End-to-end tests for controller behavior.
   - Utilizes JUnit 5, Mockito, and WebTestClient for testing.

5. **Scalable and Reactive**:
   - Built with reactive programming support using **Spring WebFlux**.
   - Leverages Undertow for high-performance HTTP handling.

6. **Schema-Driven Development**:
   - Generates Java classes from an XSD schema using JAXB.

---

## **Tech Stack**
### **Backend Framework**
- **Spring Boot 3.3.7**
- **Spring WebFlux**
- **Spring Web Services**
- **Spring Actuator** for monitoring and metrics.

### **Build Tool**
- **Maven**

### **Dependencies**
- **[pokeapi-reactor](https://github.com/SirSkaro/pokeapi-reactor/tree/master)**: Reactor-based client for PokeAPI.
- **Springdoc OpenAPI**: API documentation with Swagger UI.
- **Lombok**: Simplified boilerplate code.
- **Undertow**: Lightweight web server for reactive applications.

### **Testing Frameworks**
- **JUnit 5**
- **Mockito**
- **Reactor Test**
- **Spring WebFlux Test**

---

## **Installation**

### **Prerequisites**
- Java 17 or later
- Maven 3.6.0 or later

### **Clone the Repository**
```bash
git clone https://github.com/your-repository/pokemon-app.git
cd pokemon-app
