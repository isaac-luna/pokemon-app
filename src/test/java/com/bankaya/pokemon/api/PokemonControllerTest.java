package com.bankaya.pokemon.api;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.bankaya.pokemon.adapter.IPokemonRestAdapter;
import com.bankaya.pokemon.dto.PokemonAbilityDto;
import com.bankaya.pokemon.dto.PokemonDto;
import com.bankaya.pokemon.dto.PokemonHeldItemDto;
import com.bankaya.pokemon.fixture.PokemonFixture;

import reactor.core.publisher.Mono;

/**
 * Unit test class for {@link PokemonController}.
 * <p>
 * This class contains tests for the REST endpoints exposed by the {@code PokemonController}.
 * The tests verify that the endpoints return the expected HTTP responses and data
 * when interacting with the mocked {@link IPokemonRestAdapter}.
 * </p>
 *
 * <p><strong>Annotations:</strong></p>
 * <ul>
 *   <li>{@link WebFluxTest}: Configures the test context for testing a Spring WebFlux controller.
 *   </li>
 *   <li>{@link MockBean}: Creates a mock instance of {@link IPokemonRestAdapter} to simulate 
 *   interactions with the underlying adapter.</li>
 * </ul>
 *
 * <p><strong>Purpose:</strong></p>
 * <ul>
 *   <li>Validates the HTTP behavior of REST endpoints in the {@link PokemonController}.</li>
 *   <li>Ensures that the controller correctly interacts with the {@link IPokemonRestAdapter} and 
 *   returns appropriate responses.</li>
 *   <li>Tests the structure and content of the responses using {@link WebTestClient}.</li>
 * </ul>
 *
 * <p><strong>Usage:</strong></p>
 * <ul>
 *   <li>Executed as part of the unit testing suite to validate REST API functionality.</li>
 *   <li>Uses mocked adapter responses to isolate the controller behavior from the business logic.
 *   </li>
 * </ul>
 *
 * @see PokemonController
 * @see IPokemonRestAdapter
 * @see WebTestClient
 */
@WebFluxTest(PokemonController.class)
public class PokemonControllerTest {

    /** Instance of {@link WebTestClient} used to simulate HTTP requests and validate responses. */
    @Autowired
    private WebTestClient webTestClient;

    /** Mocked instance of {@link IPokemonRestAdapter} used to simulate adapter interactions. */
    @MockBean
    private IPokemonRestAdapter adapter;

    /** Sample {@link PokemonDto} object used as test data. */
    private PokemonDto pokemon;
    
    /** Sample list of {@link PokemonAbilityDto} objects used as test data. */
    private List<PokemonAbilityDto> pokemonAbilities;
    
    /** Sample list of {@link PokemonHeldItemDto} objects used as test data. */
    private List<PokemonHeldItemDto> pokemonHeldItems;
    
    /** Sample identifier (name or ID) for fetching Pokemon data. */
    private String nameOrId;

    /**
     * Sets up the test environment before each test case.
     * <p>
     * Initializes sample Pokemon data using fixtures to ensure consistent and reliable test inputs.
     * </p>
     */
    @BeforeEach
    public void setup() {
        pokemon = PokemonFixture.createSamplePokemonDto();
        nameOrId = "chansey";
        pokemonAbilities = PokemonFixture.createSampleAbilities();
        pokemonHeldItems = PokemonFixture.createSampleHeldItems();
    }

    /**
     * Tests the `GET /api/v1/pokemon/{nameOrId}` endpoint to ensure it returns Pokemon details 
     * correctly.
     * <p>
     * <strong>Scenario:</strong>
     * The adapter is mocked to return a predefined {@link PokemonDto}. The endpoint is invoked,
     * and the response is validated for HTTP status, content type, and body content.
     * </p>
     */
    @Test
    public void testGetPokemonDetails() {
        Mockito.when(adapter.getPokemonDetails(nameOrId)).thenReturn(Mono.just(pokemon));
        webTestClient.get().uri("/api/v1/pokemon/{nameOrId}",
                nameOrId).accept(MediaType.APPLICATION_JSON).exchange().expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON).expectBody(PokemonDto.class)
                .isEqualTo(pokemon);
        Mockito.verify(adapter,
                Mockito.times(1)).getPokemonDetails(nameOrId);
    }

    /**
     * Tests the `GET /api/v1/pokemon/{nameOrId}/abilities` endpoint to ensure it returns Pokemon 
     * abilities correctly.
     * <p>
     * <strong>Scenario:</strong>
     * The adapter is mocked to return a predefined list of {@link PokemonAbilityDto}. The endpoint
     *  is invoked,
     * and the response is validated for HTTP status, content type, and body content.
     * </p>
     */
    @Test
    public void testGetPokemonAbilities() {
        Mockito.when(adapter.getPokemonAbilities(nameOrId)).thenReturn(Mono.just(pokemonAbilities));
        webTestClient.get().uri("/api/v1/pokemon/{nameOrId}/abilities",
                nameOrId).accept(MediaType.APPLICATION_JSON).exchange().expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBodyList(PokemonAbilityDto.class).isEqualTo(pokemonAbilities);
        Mockito.verify(adapter,
                Mockito.times(1)).getPokemonAbilities(nameOrId);
    }

    /**
     * Tests the `GET /api/v1/pokemon/{nameOrId}/held-items` endpoint to ensure it returns Pokemon 
     * held items correctly.
     * <p>
     * <strong>Scenario:</strong>
     * The adapter is mocked to return a predefined list of {@link PokemonHeldItemDto}. The 
     * endpoint is invoked,
     * and the response is validated for HTTP status, content type, and body content.
     * </p>
     */
    @Test
    public void testGetPokemonHeldItems() {
        Mockito.when(adapter.getPokemonHeldItems(nameOrId)).thenReturn(Mono.just(pokemonHeldItems));
        webTestClient.get().uri("/api/v1/pokemon/{nameOrId}/held-items",
                nameOrId).accept(MediaType.APPLICATION_JSON).exchange().expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBodyList(PokemonHeldItemDto.class).isEqualTo(pokemonHeldItems);
        Mockito.verify(adapter,
                Mockito.times(1)).getPokemonHeldItems(nameOrId);
    }
}