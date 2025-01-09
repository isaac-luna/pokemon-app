package com.bankaya.pokemon.api;

import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bankaya.pokemon.adapter.IPokemonRestAdapter;
import com.bankaya.pokemon.dto.PokemonAbilityDto;
import com.bankaya.pokemon.dto.PokemonDto;
import com.bankaya.pokemon.dto.PokemonHeldItemDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

/**
 * REST controller for managing Pokemon information.
 * <p>
 * This controller provides endpoints to retrieve Pokemon details, abilities, and held items.
 * It leverages the {@link IPokemonRestAdapter} to interact with the underlying Pokemon services.
 * </p>
 * 
 * <p><strong>Base URL:</strong> {@code /api/v1/pokemon}</p>
 * 
 * <p><strong>Annotations:</strong>
 * <ul>
 *   <li>{@link RestController}: Indicates that this class is a REST controller.</li>
 *   <li>{@link RequestMapping}: Maps HTTP requests to handler methods of MVC and REST controllers.
 *   </li>
 *   <li>{@link Tag}: Used for grouping and describing API endpoints in Swagger documentation.
 *   </li>
 *   <li>{@link RequiredArgsConstructor}: Lombok annotation to generate a constructor with 
 *   required arguments.</li>
 *   <li>{@link Slf4j}: Lombok annotation to generate a logger instance.</li>
 * </ul>
 * </p>
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/pokemon")
@Tag(name = "Pokemon", description = "Endpoints to manage Pokemon information")
@Slf4j
public class PokemonController {

    /**
     * Adapter for interacting with Pokemon RESTful services.
     */
    private final IPokemonRestAdapter adapter;

    /**
     * Retrieves detailed information about a specific Pokemon by its name or ID.
     *
     * @param nameOrId The name or ID of the Pokemon whose details are to be fetched.
     * @return A {@link Mono} emitting a {@link PokemonDto} containing detailed information about 
     * the requested Pokemon.
     * 
     * <p><strong>Endpoint:</strong> {@code GET /api/v1/pokemon/{nameOrId}}</p>
     * <p><strong>Produces:</strong> {@code application/json}</p>
     * 
     * <p><strong>Swagger Documentation:</strong></p>
     * <ul>
     *   <li><strong>Summary:</strong> Get Pokemon details by name</li>
     *   <li><strong>Description:</strong> Returns the detailed information about a Pokemon 
     *   (height, weight, base experience, etc.).</li>
     * </ul>
     */
    @Operation(
        summary = "Get Pokemon details by name",
        description = "Returns the detailed information about a Pokemon (height, weight, base experience, etc.).")
    @GetMapping(path = "/{nameOrId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<PokemonDto> getPokemonDetails(@PathVariable String nameOrId) {
        log.info("Get Pokemon details from: {}",
                nameOrId);
        return adapter.getPokemonDetails(nameOrId);
    }

    /**
     * Retrieves the list of abilities of a specific Pokemon by its name or ID.
     *
     * @param nameOrId The name or ID of the Pokemon whose abilities are to be fetched.
     * @return A {@link Mono} emitting a {@link List} of {@link PokemonAbilityDto} representing 
     * the abilities of the requested Pokemon.
     * 
     * <p><strong>Endpoint:</strong> {@code GET /api/v1/pokemon/{nameOrId}/abilities}</p>
     * 
     * <p><strong>Swagger Documentation:</strong></p>
     * <ul>
     *   <li><strong>Summary:</strong> Get Pokemon abilities by name</li>
     *   <li><strong>Description:</strong> Returns all the abilities that a specific Pokemon has.
     *   </li>
     * </ul>
     */
    @Operation(
        summary = "Get Pokemon abilities by name",
        description = "Returns all the abilities that a specific Pokemon has.")
    @GetMapping("/{nameOrId}/abilities")
    public Mono<List<PokemonAbilityDto>> getPokemonAbilities(@PathVariable String nameOrId) {
        log.info("Get Pokemon abilities from: {}",
                nameOrId);
        return adapter.getPokemonAbilities(nameOrId);
    }

    /**
     * Retrieves the list of held items of a specific Pokemon by its name or ID.
     *
     * @param nameOrId The name or ID of the Pokemon whose held items are to be fetched.
     * @return A {@link Mono} emitting a {@link List} of {@link PokemonHeldItemDto} representing
     *  the items held by the requested Pokemon.
     * 
     * <p><strong>Endpoint:</strong> {@code GET /api/v1/pokemon/{nameOrId}/held-items}</p>
     * 
     * <p><strong>Swagger Documentation:</strong></p>
     * <ul>
     *   <li><strong>Summary:</strong> Get Pokemon items by name</li>
     *   <li><strong>Description:</strong> Returns all the held items that a specific Pokemon 
     *   can carry.</li>
     * </ul>
     */
    @Operation(
        summary = "Get Pokemon items by name",
        description = "Returns all the held items that a specific Pokemon can carry.")
    @GetMapping("/{nameOrId}/held-items")
    public Mono<List<PokemonHeldItemDto>> getPokemonHeldItems(@PathVariable String nameOrId) {
        log.info("Get Pokemon held items from: {}",
                nameOrId);
        return adapter.getPokemonHeldItems(nameOrId);
    }
}