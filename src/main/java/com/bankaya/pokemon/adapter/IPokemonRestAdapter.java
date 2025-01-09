package com.bankaya.pokemon.adapter;

import java.util.List;

import com.bankaya.pokemon.dto.PokemonAbilityDto;
import com.bankaya.pokemon.dto.PokemonDto;
import com.bankaya.pokemon.dto.PokemonHeldItemDto;

import reactor.core.publisher.Mono;

/**
 * Interface defining the available operations for adapting RESTful services related to Pokemon.
 * Provides methods to retrieve Pokemon details, abilities, and held items.
 */
public interface IPokemonRestAdapter {

    /**
     * Retrieves the complete details of a specific Pokemon.
     *
     * @param nameOrId The name or ID of the Pokemon whose details are to be fetched.
     * @return A {@link Mono} emitting a {@link PokemonDto} containing the details of the requested
     *         Pokemon.
     */
    Mono<PokemonDto> getPokemonDetails(String nameOrId);

    /**
     * Retrieves the list of abilities of a specific Pokemon.
     *
     * @param nameOrId The name or ID of the Pokemon whose abilities are to be fetched.
     * @return A {@link Mono} emitting a {@link List} of {@link PokemonAbilityDto} representing the
     *         abilities of the requested Pokemon.
     */
    Mono<List<PokemonAbilityDto>> getPokemonAbilities(String nameOrId);

    /**
     * Retrieves the list of items held by a specific Pokemon.
     *
     * @param nameOrId The name or ID of the Pokemon whose held items are to be fetched.
     * @return A {@link Mono} emitting a {@link List} of {@link PokemonHeldItemDto} representing the
     *         items held by the requested Pokemon.
     */
    Mono<List<PokemonHeldItemDto>> getPokemonHeldItems(String nameOrId);

}
