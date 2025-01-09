package com.bankaya.pokemon.adapter;

import com.bankaya.pokemon.xsd.GetPokemonAbilitiesRequest;
import com.bankaya.pokemon.xsd.GetPokemonAbilitiesResponse;
import com.bankaya.pokemon.xsd.GetPokemonDetailsRequest;
import com.bankaya.pokemon.xsd.GetPokemonDetailsResponse;
import com.bankaya.pokemon.xsd.GetPokemonHeldItemsRequest;
import com.bankaya.pokemon.xsd.GetPokemonHeldItemsResponse;

/**
 * Interface defining the available operations for adapting SOAP services related to Pokemon.
 * Provides methods to retrieve Pokemon details, abilities, and held items.
 */
public interface IPokemonSoapAdapter {

    /**
     * Retrieves the complete details of a specific Pokemon.
     *
     * @param request The request object containing the name or ID of the Pokemon whose details are
     *                to be fetched.
     * @return A response object containing the details of the requested Pokemon.
     */
    GetPokemonDetailsResponse getPokemonDetails(GetPokemonDetailsRequest request);

    /**
     * Retrieves the list of abilities of a specific Pokemon.
     *
     * @param request The request object containing the name or ID of the Pokemon whose abilities
     *                are to be fetched.
     * @return A response object containing the list of abilities of the requested Pokemon.
     */
    GetPokemonAbilitiesResponse getPokemonAbilities(GetPokemonAbilitiesRequest request);

    /**
     * Retrieves the list of items held by a specific Pokemon.
     *
     * @param request The request object containing the name or ID of the Pokemon whose held items
     *                are to be fetched.
     * @return A response object containing the list of items held by the requested Pokemon.
     */
    GetPokemonHeldItemsResponse getPokemonHeldItems(GetPokemonHeldItemsRequest request);
}
