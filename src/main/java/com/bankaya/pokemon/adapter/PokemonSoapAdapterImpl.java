package com.bankaya.pokemon.adapter;

import java.util.List;
import org.springframework.stereotype.Component;
import com.bankaya.pokemon.service.IPokemonService;
import com.bankaya.pokemon.xsd.GetPokemonAbilitiesRequest;
import com.bankaya.pokemon.xsd.GetPokemonAbilitiesResponse;
import com.bankaya.pokemon.xsd.GetPokemonDetailsRequest;
import com.bankaya.pokemon.xsd.GetPokemonDetailsResponse;
import com.bankaya.pokemon.xsd.GetPokemonHeldItemsRequest;
import com.bankaya.pokemon.xsd.GetPokemonHeldItemsResponse;
import com.bankaya.pokemon.xsd.Pokemon;
import com.bankaya.pokemon.xsd.PokemonAbility;
import com.bankaya.pokemon.xsd.PokemonHeldItem;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.RequiredArgsConstructor;

/**
 * Implementation of the {@link IPokemonSoapAdapter} interface that utilizes {@link IPokemonService}
 * to interact with Pokemon services and provide responses to SOAP requests.
 * <p>
 * This class is managed by the Spring container and uses dependency injection to receive an
 * instance of {@link IPokemonService}.
 * </p>
 */
@RequiredArgsConstructor
@Component
public class PokemonSoapAdapterImpl implements IPokemonSoapAdapter {
    
    /**
     * Service providing operations related to Pokemon.
     */
    private final IPokemonService pokemonService;

    /**
     * {@inheritDoc}
     *
     * Implements the retrieval of Pokemon details using the {@link IPokemonService}.
     * Maps the service response to a {@link GetPokemonDetailsResponse} object.
     *
     * @param request The request object containing the name or ID of the Pokemon whose details are 
     * to be fetched.
     * @return A response object containing the details of the requested Pokemon, or {@code null} 
     * if not found.
     */
    @Override
    public GetPokemonDetailsResponse getPokemonDetails(GetPokemonDetailsRequest request) {
        return pokemonService.getPokemonDetails(request.getNameOrId(),
                Pokemon.class).map(detail -> {
                    GetPokemonDetailsResponse response = new GetPokemonDetailsResponse();
                    response.setPokemon(detail);
                    return response;
                }).block();
    }

    /**
     * {@inheritDoc}
     *
     * Implements the retrieval of a Pokemon's abilities using the {@link IPokemonService}.
     * Maps the service response to a {@link GetPokemonAbilitiesResponse} object.
     *
     * @param request The request object containing the name or ID of the Pokemon whose abilities 
     * are to be fetched.
     * @return A response object containing the list of abilities of the requested Pokemon, or 
     * {@code null} if not found.
     */
    @Override
    public GetPokemonAbilitiesResponse getPokemonAbilities(GetPokemonAbilitiesRequest request) {
        return pokemonService.getPokemonAbilities(request.getNameOrId(),
                new TypeReference<List<PokemonAbility>>() {
                }).map(abilities -> {
                    GetPokemonAbilitiesResponse response = new GetPokemonAbilitiesResponse();
                    response.getAbilities().addAll(abilities);
                    return response;
                }).block();
    }

    /**
     * {@inheritDoc}
     *
     * Implements the retrieval of items held by a Pokemon using the {@link IPokemonService}.
     * Maps the service response to a {@link GetPokemonHeldItemsResponse} object.
     *
     * @param request The request object containing the name or ID of the Pokemon whose held items
     *  are to be fetched.
     * @return A response object containing the list of items held by the requested Pokemon, or 
     * {@code null} if not found.
     */
    @Override
    public GetPokemonHeldItemsResponse getPokemonHeldItems(GetPokemonHeldItemsRequest request) {
        return pokemonService.getPokemonHeldItems(request.getNameOrId(),
                new TypeReference<List<PokemonHeldItem>>() {
                }).map(items -> {
                    GetPokemonHeldItemsResponse response = new GetPokemonHeldItemsResponse();
                    response.getHeldItems().addAll(items);
                    return response;
                }).block();
    }

}
