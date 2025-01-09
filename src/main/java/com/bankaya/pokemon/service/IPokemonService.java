package com.bankaya.pokemon.service;

import java.util.List;
import com.fasterxml.jackson.core.type.TypeReference;
import reactor.core.publisher.Mono;

/**
 * Service interface for managing Pokemon-related operations.
 * 
 * <p>This interface defines the contract for fetching Pokemon details, abilities,
 * and held items. It utilizes reactive programming paradigms provided by Project Reactor
 * to handle asynchronous data streams.</p>
 * 
 * <p>Implementations of this interface are responsible for interacting with external APIs,
 * databases, or other data sources to retrieve and process Pokemon information.</p>
 * 
 * <p>Type Parameters:</p>
 * <ul>
 *   <li><strong>T</strong> - The type to which Pokemon details should be converted.</li>
 *   <li><strong>U</strong> - The type to which each Pokemon ability should be converted.</li>
 *   <li><strong>V</strong> - The type to which each held item should be converted.</li>
 * </ul>
 */
public interface IPokemonService {

    /**
     * Retrieves detailed information about a specific Pokemon.
     * 
     * <p>This method fetches the Pokemon data based on its name or ID and converts it
     * into the specified target type.</p>
     * 
     * @param <T>         The type to which the Pokemon details should be converted.
     * @param nameOrId    The name or ID of the Pokemon to retrieve.
     * @param targetType  The {@link Class} object representing the target type.
     * @return A {@link Mono} emitting the Pokemon details converted to the target type.
     */
    <T> Mono<T> getPokemonDetails(String nameOrId, Class<T> targetType);

    /**
     * Retrieves a list of abilities possessed by a specific Pokemon.
     * 
     * <p>This method fetches the Pokemon's abilities based on its name or ID and converts
     * them into a list of the specified type.</p>
     * 
     * @param <U>      The type to which each Pokemon ability should be converted.
     * @param nameOrId The name or ID of the Pokemon whose abilities are to be retrieved.
     * @param typeRef  The {@link TypeReference} representing the target type for the list of 
     * abilities.
     * @return A {@link Mono} emitting a list of Pokemon abilities converted to the specified type.
     */
    <U> Mono<List<U>> getPokemonAbilities(String nameOrId, TypeReference<List<U>> typeRef);

    /**
     * Retrieves a list of items held by a specific Pokemon.
     * 
     * <p>
     * This method fetches the Pokemon's held items based on its name or ID and converts them into a
     * list of the specified type.
     * </p>
     * 
     * @param <V>      The type to which each held item should be converted.
     * @param nameOrId The name or ID of the Pokemon whose held items are to be retrieved.
     * @param typeRef  The {@link TypeReference} representing the target type for the list of held
     *                 items.
     * @return A {@link Mono} emitting a list of held items converted to the specified type.
     */
    <V> Mono<List<V>> getPokemonHeldItems(String nameOrId, TypeReference<List<V>> typeRef);
}