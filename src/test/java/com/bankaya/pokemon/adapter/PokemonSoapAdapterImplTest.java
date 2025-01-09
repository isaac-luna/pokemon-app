package com.bankaya.pokemon.adapter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bankaya.pokemon.fixture.PokemonFixture;
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
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;

import reactor.core.publisher.Mono;

/**
 * Unit test class for {@link PokemonSoapAdapterImpl}.
 * <p>
 * This class tests the functionality of the {@code PokemonSoapAdapterImpl} class, ensuring
 * proper interactions with the {@link IPokemonService} and correct responses for SOAP requests.
 * </p>
 *
 * <p><strong>Annotations:</strong></p>
 * <ul>
 *   <li>{@link ExtendWith}: Integrates Mockito with JUnit 5, enabling the use of Mockito 
 *   annotations.</li>
 *   <li>{@link Mock}: Creates mock instances for dependencies.</li>
 *   <li>{@link InjectMocks}: Injects mock dependencies into the class under test.</li>
 * </ul>
 *
 * <p><strong>Purpose:</strong></p>
 * <ul>
 *   <li>Validates the behavior of {@code PokemonSoapAdapterImpl} methods.</li>
 *   <li>Ensures proper interaction with {@link IPokemonService} using mocked data.</li>
 *   <li>Verifies the accuracy of the responses generated for SOAP requests.</li>
 * </ul>
 *
 * <p><strong>Usage:</strong></p>
 * <ul>
 *   <li>Executed as part of the unit testing suite to validate SOAP adapter behavior.</li>
 *   <li>Utilizes predefined fixtures for consistent and reliable test data.</li>
 * </ul>
 *
 * @see PokemonSoapAdapterImpl
 * @see IPokemonService
 * @see PokemonFixture
 */
@ExtendWith(MockitoExtension.class)
public class PokemonSoapAdapterImplTest {

    /** Mocked instance of {@link IPokemonService} used to simulate service interactions. */
    @Mock
    private IPokemonService pokemonService;

    /** Instance of {@link PokemonSoapAdapterImpl} with injected mock dependencies. */
    @InjectMocks
    private PokemonSoapAdapterImpl adapter;

    /** ObjectMapper configured with {@link PropertyNamingStrategies#SNAKE_CASE} for serialization 
     * consistency */
    private final ObjectMapper objectMapper = new ObjectMapper();

    /** Sample {@link Pokemon} object used as test data. */
    private Pokemon pokemon;
    
    /** Sample list of {@link PokemonAbility} used as test data. */
    private List<PokemonAbility> pokemonAbilities;
    
    /** Sample list of {@link PokemonHeldItem} used as test data.*/
    private List<PokemonHeldItem> pokemonHeldItems;
    
    /** Sample identifier (name or ID) for fetching Pokemon data. */
    private String nameOrId;

    @BeforeEach
    public void setup() {
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
        pokemon = objectMapper.convertValue(PokemonFixture.createSamplePokemonDto(),
                Pokemon.class);
        nameOrId = "chansey";
        pokemonAbilities = objectMapper.convertValue(PokemonFixture.createSampleAbilities(),
                new TypeReference<List<PokemonAbility>>() {
                });
        pokemonHeldItems = objectMapper.convertValue(PokemonFixture.createSampleHeldItems(),
                new TypeReference<List<PokemonHeldItem>>() {
                });
    }

    /**
     * Sets up the test environment before each test case.
     * <p>
     * Initializes sample Pokemon data using fixtures and configures the {@code ObjectMapper}
     * for consistent serialization and deserialization.
     * </p>
     */
    @Test
    public void testGetPokemonDetails() {
        GetPokemonDetailsRequest request = new GetPokemonDetailsRequest();
        request.setNameOrId(nameOrId);
        Mockito.when(pokemonService.getPokemonDetails(nameOrId,
                Pokemon.class)).thenReturn(Mono.just(pokemon));
        GetPokemonDetailsResponse response = adapter.getPokemonDetails(request);
        assertNotNull(response);
        assertNotNull(response.getPokemon());
        assertEquals(pokemon.getId(),
                response.getPokemon().getId());
        assertEquals(pokemon.getName(),
                response.getPokemon().getName());
        assertEquals(pokemon.getBaseExperience(),
                response.getPokemon().getBaseExperience());
        Mockito.verify(pokemonService,
                Mockito.times(1)).getPokemonDetails(nameOrId,
                        Pokemon.class);
    }

    /**
     * Tests the {@code getPokemonDetails} method to ensure it correctly fetches and returns 
     * Pokemon details.
     * <p>
     * <strong>Scenario:</strong>
     * The service is mocked to return a predefined {@link Pokemon} object. The adapter is invoked
     * with a {@link GetPokemonDetailsRequest}, and the response is validated for correctness.
     * </p>
     */
    @SuppressWarnings("unchecked")
    @Test
    public void testGetPokemonAbilities() {
        GetPokemonAbilitiesRequest request = new GetPokemonAbilitiesRequest();
        request.setNameOrId(nameOrId);
        when(pokemonService.getPokemonAbilities(eq(nameOrId),
                any(TypeReference.class))).thenReturn(Mono.just(pokemonAbilities));
        GetPokemonAbilitiesResponse response = adapter.getPokemonAbilities(request);
        assertNotNull(response);
        assertNotNull(response.getAbilities());
        assertEquals(pokemonAbilities.size(),
                response.getAbilities().size());
        assertEquals(pokemonAbilities.get(0).getAbility().getName(),
                response.getAbilities().get(0).getAbility().getName());
        assertEquals(pokemonAbilities.get(2).getAbility().getName(),
                response.getAbilities().get(2).getAbility().getName());
        assertFalse(response.getAbilities().get(0).isIsHidden());
        assertTrue(response.getAbilities().get(2).isIsHidden());
        verify(pokemonService,
                times(1)).getPokemonAbilities(eq(nameOrId),
                        any(TypeReference.class));
    }

    /**
     * Tests the {@code getPokemonAbilities} method to ensure it correctly fetches and returns 
     * Pokemon abilities.
     * <p>
     * <strong>Scenario:</strong>
     * The service is mocked to return a predefined list of {@link PokemonAbility} objects. The 
     * adapter is invoked
     * with a {@link GetPokemonAbilitiesRequest}, and the response is validated for correctness.
     * </p>
     */
    @SuppressWarnings("unchecked")
    @Test
    public void testGetPokemonHeldItems() {
        GetPokemonHeldItemsRequest request = new GetPokemonHeldItemsRequest();
        request.setNameOrId(nameOrId);
        when(pokemonService.getPokemonHeldItems(eq(nameOrId),
                any(TypeReference.class))).thenReturn(Mono.just(pokemonHeldItems));
        GetPokemonHeldItemsResponse response = adapter.getPokemonHeldItems(request);
        assertNotNull(response);
        assertNotNull(response.getHeldItems());
        assertEquals(pokemonHeldItems.size(),
                response.getHeldItems().size());
        assertEquals(pokemonHeldItems.get(0).getItem().getName(),
                response.getHeldItems().get(0).getItem().getName());
        assertEquals(pokemonHeldItems.get(1).getItem().getUrl(),
                response.getHeldItems().get(1).getItem().getUrl());
        assertEquals(pokemonHeldItems.get(1).getVersionDetails().get(0).getRarity(),
                response.getHeldItems().get(1).getVersionDetails().get(0).getRarity());
        Mockito.verify(pokemonService,
                Mockito.times(1)).getPokemonHeldItems(eq(nameOrId),
                        any(TypeReference.class));
    }

}
