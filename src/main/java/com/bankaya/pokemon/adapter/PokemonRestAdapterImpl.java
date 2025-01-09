package com.bankaya.pokemon.adapter;

import java.util.List;
import org.springframework.stereotype.Component;
import com.bankaya.pokemon.dto.PokemonAbilityDto;
import com.bankaya.pokemon.dto.PokemonDto;
import com.bankaya.pokemon.dto.PokemonHeldItemDto;
import com.bankaya.pokemon.service.IPokemonService;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

/**
 * Implementation of the {@link IPokemonRestAdapter} interface that utilizes {@link IPokemonService}
 * to interact with Pokemon RESTful services and provide reactive responses.
 * <p>
 * This class is managed by the Spring container and uses dependency injection to receive an 
 * instance of {@link IPokemonService}.
 * </p>
 */
@RequiredArgsConstructor
@Component
public class PokemonRestAdapterImpl implements IPokemonRestAdapter {
    
    /**
     * Service providing operations related to Pokemon.
     */
    private final IPokemonService pokemonService;

    /**
     * {@inheritDoc}
     *
     * Implements the retrieval of Pokemon details using the {@link IPokemonService}.
     * Returns a {@link Mono} emitting a {@link PokemonDto} containing the details of the requested 
     * Pokemon.
     *
     * @param nameOrId The name or ID of the Pokemon whose details are to be fetched.
     * @return A {@link Mono} emitting a {@link PokemonDto} with the Pokemon details.
     */
    @Override
    public Mono<PokemonDto> getPokemonDetails(String nameOrId) {
        return pokemonService.getPokemonDetails(nameOrId,
                PokemonDto.class);
    }

    /**
     * {@inheritDoc}
     *
     * Implements the retrieval of a Pokemon's abilities using the {@link IPokemonService}.
     * Returns a {@link Mono} emitting a {@link List} of {@link PokemonAbilityDto} representing the 
     * abilities of the requested Pokemon.
     *
     * @param nameOrId The name or ID of the Pokemon whose abilities are to be fetched.
     * @return A {@link Mono} emitting a {@link List} of {@link PokemonAbilityDto} with the 
     * Pokemon's abilities.
     */
    @Override
    public Mono<List<PokemonAbilityDto>> getPokemonAbilities(String nameOrId) {
        return pokemonService.getPokemonAbilities(nameOrId,
                new TypeReference<List<PokemonAbilityDto>>() {
                });
    }

    /**
     * {@inheritDoc}
     *
     * Implements the retrieval of items held by a Pokemon using the {@link IPokemonService}.
     * Returns a {@link Mono} emitting a {@link List} of {@link PokemonHeldItemDto} representing 
     * the items held by the requested Pokemon.
     *
     * @param nameOrId The name or ID of the Pokemon whose held items are to be fetched.
     * @return A {@link Mono} emitting a {@link List} of {@link PokemonHeldItemDto} with the 
     * Pokemon's held items.
     */
    @Override
    public Mono<List<PokemonHeldItemDto>> getPokemonHeldItems(String nameOrId) {
        return pokemonService.getPokemonHeldItems(nameOrId,
                new TypeReference<List<PokemonHeldItemDto>>() {
                });
    }
}
