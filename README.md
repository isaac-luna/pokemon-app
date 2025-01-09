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
git clone https://github.com/isaac-luna/pokemon-app.git
cd pokemon-app
```



### **Usage**

**Run the Application**

 To start the application, use:

```bash
mvn spring-boot:run
```

The application will run on http://localhost:8080.


**REST Endpoints**

| Endpoint                                           | Method | Description                              |
|----------------------------------------------------|--------|------------------------------------------|
| `/api/v1/pokemon/{nameOrId}`               | GET    | Fetch Pokémon details.                   |
| `/api/v1/pokemon/{nameOrId}/abilities`  | GET    | Retrieve Pokémon abilities.              |
| `/api/v1/pokemon/{nameOrId}/held-items` | GET    | Get held items for a Pokémon.            |


**SOAP Endpoints**

| Operation                         | Description                              |
|-----------------------------------|------------------------------------------|
| `getPokemonDetails`               | Fetch Pokémon details via SOAP.         |
| `getPokemonAbilities`             | Retrieve Pokémon abilities via SOAP.    |
| `getPokemonHeldItems`             | Get held items via SOAP.                |


SOAP WSDL is available at:

http://localhost:8080/ws/pokemon.wsdl

##Interactive API Documentation

Swagger UI is available at:

http://localhost:8080/swagger-ui.html

##Development

**Project Structure**

```plaintext
src/main/java:
    com.bankaya.pokemon.controller: REST controllers.
    com.bankaya.pokemon.adapter: Service adapters for REST and SOAP integration.
    com.bankaya.pokemon.service: Core business logic.
    com.bankaya.pokemon.dto: Data transfer objects (DTOs).
    com.bankaya.pokemon.fixture: Test data fixtures.

src/main/resources:
    application.properties: Configuration properties.
    pokemon.xsd: Schema definition for SOAP services.

src/test/java:
    Unit and integration tests.
```

**Generate JAXB Classes**

The pokemon.xsd schema is used to generate Java classes. Run the following command to regenerate the classes:

```bash
mvn jaxb2:xjc
```