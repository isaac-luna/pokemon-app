package com.bankaya.pokemon.endpoint;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.bankaya.pokemon.adapter.IPokemonSoapAdapter;
import com.bankaya.pokemon.xsd.GetPokemonAbilitiesRequest;
import com.bankaya.pokemon.xsd.GetPokemonAbilitiesResponse;
import com.bankaya.pokemon.xsd.GetPokemonDetailsRequest;
import com.bankaya.pokemon.xsd.GetPokemonDetailsResponse;
import com.bankaya.pokemon.xsd.GetPokemonHeldItemsRequest;
import com.bankaya.pokemon.xsd.GetPokemonHeldItemsResponse;

import lombok.RequiredArgsConstructor;

/**
 * SOAP endpoint for managing Pokemon information.
 * <p>
 * This endpoint provides operations to retrieve Pokemon details, abilities, and held items via 
 * SOAP requests.
 * It leverages the {@link IPokemonSoapAdapter} to interact with the underlying Pokemon services.
 * </p>
 * 
 * <p><strong>Namespace URI:</strong> {@code http://bankaya.com/pokemon/xsd}</p>
 * 
 * <p><strong>Annotations:</strong>
 * <ul>
 *   <li>{@link Endpoint}: Indicates that this class is a Spring Web Service endpoint.</li>
 *   <li>{@link RequiredArgsConstructor}: Lombok annotation to generate a constructor with required
 *    arguments.</li>
 * </ul>
 * </p>
 */
@Endpoint
@RequiredArgsConstructor
public class PokemonEndpoint {
    
    /** Adapter for interacting with Pokemon SOAP services. */
    private final IPokemonSoapAdapter adapter;

    /** Namespace URI for the SOAP requests. */
    private static final String NAMESPACE_URI = "http://bankaya.com/pokemon/xsd";

    /**
     * Handles the SOAP request to retrieve detailed information about a specific Pokemon.
     *
     * @param request The {@link GetPokemonDetailsRequest} containing the name or ID of the Pokemon.
     * @return A {@link GetPokemonDetailsResponse} containing detailed information about the 
     * requested Pokemon.
     * 
     * <p><strong>SOAP Action:</strong> {@code getPokemonDetailsRequest}</p>
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPokemonDetailsRequest")
    @ResponsePayload
    public GetPokemonDetailsResponse getPokemonDetails(
            @RequestPayload GetPokemonDetailsRequest request) {
        return adapter.getPokemonDetails(request);
    }

    /**
     * Handles the SOAP request to retrieve the list of abilities of a specific Pokemon.
     *
     * @param request The {@link GetPokemonAbilitiesRequest} containing the name or ID of the 
     * Pokemon.
     * @return A {@link GetPokemonAbilitiesResponse} containing the abilities of the requested 
     * Pokemon.
     * 
     * <p><strong>SOAP Action:</strong> {@code getPokemonAbilitiesRequest}</p>
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPokemonAbilitiesRequest")
    @ResponsePayload
    public GetPokemonAbilitiesResponse getPokemonAbilities(
            @RequestPayload GetPokemonAbilitiesRequest request) {
        return adapter.getPokemonAbilities(request);
    }

    /**
     * Handles the SOAP request to retrieve the list of held items of a specific Pokemon.
     *
     * @param request The {@link GetPokemonHeldItemsRequest} containing the name or ID of the 
     * Pokemon.
     * @return A {@link GetPokemonHeldItemsResponse} containing the held items of the requested 
     * Pokemon.
     * 
     * <p><strong>SOAP Action:</strong> {@code getPokemonHeldItemsRequest}</p>
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPokemonHeldItemsRequest")
    @ResponsePayload
    public GetPokemonHeldItemsResponse getPokemonHeldItems(
            @RequestPayload GetPokemonHeldItemsRequest request) {
        return adapter.getPokemonHeldItems(request);
    }
}
