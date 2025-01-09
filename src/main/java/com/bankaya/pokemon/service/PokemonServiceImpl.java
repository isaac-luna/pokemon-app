package com.bankaya.pokemon.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;
import skaro.pokeapi.client.PokeApiClient;
import skaro.pokeapi.resource.pokemon.Pokemon;

/**
 * Service implementation for handling Pokemon-related operations.
 * 
 * <p>This class interacts with the PokeAPI to fetch Pokemon details,
 * abilities, and held items. It utilizes reactive programming paradigms
 * provided by Project Reactor to handle asynchronous data streams.</p>
 * 
 * <p>Dependencies:</p>
 * <ul>
 *   <li>{@link PokeApiClient}: Client for interacting with the PokeAPI.</li>
 *   <li>{@link ObjectMapper}: Jackson's object mapper for converting JSON data.</li>
 * </ul>
 * 
 * <p>Annotations:</p>
 * <ul>
 *   <li>{@code @Service}: Marks this class as a Spring service component.</li>
 *   <li>{@code @Slf4j}: Enables logging capabilities using SLF4J.</li>
 *   <li>{@code @RequiredArgsConstructor}: Generates a constructor with required arguments (final fields).</li>
 * </ul>
 * 
 * @see IPokemonService
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class PokemonServiceImpl implements IPokemonService {

    /**
     * Client for fetching resources from the PokeAPI.
     */
    private final PokeApiClient pokeApiClient;
    
    /**
     * Jackson ObjectMapper for converting JSON data to Java objects.
     */
    private final ObjectMapper objectMapper;

    /**
     * Fetches a Pokemon entity from the PokeAPI based on its name or ID.
     * 
     * <p>This method sends a request to the PokeAPI to retrieve the Pokemon's details
     * and logs essential information upon successful retrieval.</p>
     * 
     * @param nameOrId The name or ID of the Pokemon to fetch.
     * @return A {@link Mono} emitting the fetched {@link Pokemon} object.
     */
    private Mono<Pokemon> fetchPokemon(String nameOrId) {
        return pokeApiClient.getResource(Pokemon.class,
                nameOrId).doOnNext(
                        p -> log.debug("Pokemon id: {}, Name: {}, Base Experience: {}",
                                p.getId(),
                                p.getName(),
                                p.getBaseExperience()));
    }

    /**
     * Retrieves detailed information about a specific Pokemon.
     * 
     * <p>This method fetches the Pokemon data and converts it into the specified target type.</p>
     * 
     * @param <T>         The type to which the Pokemon details should be converted.
     * @param nameOrId    The name or ID of the Pokemon to retrieve.
     * @param targetType  The {@link Class} object representing the target type.
     * @return A {@link Mono} emitting the Pokemon details converted to the target type.
     */
    @Override
    public <T> Mono<T> getPokemonDetails(String nameOrId, Class<T> targetType) {
        return fetchPokemon(nameOrId).map(pokemon -> objectMapper.convertValue(pokemon,
                targetType));
    }

    /**
     * Retrieves a list of abilities possessed by a specific Pokemon.
     * 
     * <p>
     * This method fetches the Pokemon data and extracts its abilities, converting them into the
     * specified type reference.
     * </p>
     * 
     * @param <U>      The type to which each Pokemon ability should be converted.
     * @param nameOrId The name or ID of the Pokemon whose abilities are to be retrieved.
     * @param typeRef  The {@link TypeReference} representing the target type for the list of
     *                 abilities.
     * @return A {@link Mono} emitting a list of Pokemon abilities converted to the specified type.
     */
    @Override
    public <U> Mono<List<U>> getPokemonAbilities(String nameOrId, TypeReference<List<U>> typeRef) {
        return fetchPokemon(nameOrId)
                .map(pokemon -> objectMapper.convertValue(pokemon.getAbilities(),
                        typeRef));
    }

    /**
     * Retrieves a list of items held by a specific Pokemon.
     * 
     * <p>
     * This method fetches the Pokemon data and extracts its held items, converting them into the
     * specified type reference.
     * </p>
     * 
     * @param <V>      The type to which each held item should be converted.
     * @param nameOrId The name or ID of the Pokemon whose held items are to be retrieved.
     * @param typeRef  The {@link TypeReference} representing the target type for the list of held
     *                 items.
     * @return A {@link Mono} emitting a list of held items converted to the specified type.
     */
    @Override
    public <V> Mono<List<V>> getPokemonHeldItems(String nameOrId, TypeReference<List<V>> typeRef) {
        return fetchPokemon(nameOrId)
                .map(pokemon -> objectMapper.convertValue(pokemon.getHeldItems(),
                        typeRef));
    }
}
