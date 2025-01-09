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
import com.bankaya.pokemon.dto.PokemonAbilityDto;
import com.bankaya.pokemon.dto.PokemonDto;
import com.bankaya.pokemon.dto.PokemonHeldItemDto;
import com.bankaya.pokemon.fixture.PokemonFixture;
import com.bankaya.pokemon.service.IPokemonService;
import com.fasterxml.jackson.core.type.TypeReference;
import reactor.core.publisher.Mono;

/**
 * Test class for {@link PokemonRestAdapterImpl}.
 * <p>
 * This class contains unit tests for the {@code PokemonRestAdapterImpl} class,
 * ensuring that it correctly interacts with the {@link IPokemonService} to fetch
 * Pokemon details, abilities, and held items.
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
 *   <li>Validates the behavior of {@code PokemonRestAdapterImpl} methods.</li>
 *   <li>Ensures proper interaction with {@link IPokemonService} using Mockito.</li>
 *   <li>Verifies that the adapter correctly processes and returns data fetched from the service.
 *   </li>
 * </ul>
 * 
 * <p><strong>Usage:</strong></p>
 * <ul>
 *   <li>Executed as part of the unit testing suite to ensure adapter correctness.</li>
 *   <li>Utilizes predefined fixtures for consistent and reliable test data.</li>
 * </ul>
 * 
 * @see PokemonRestAdapterImpl
 * @see IPokemonService
 * @see PokemonFixture
 */
@ExtendWith(MockitoExtension.class)
public class PokemonRestAdapterImplTest {
    
    /** Mocked instance of {@link IPokemonService} used to simulate service interactions. */
    @Mock
    private IPokemonService pokemonService;

    /** Instance of {@link PokemonRestAdapterImpl} with injected mock dependencies.*/
    @InjectMocks
    private PokemonRestAdapterImpl adapter;

    /** Sample {@link PokemonDto} used as test data. */
    private PokemonDto pokemon;

    /** Sample list of {@link PokemonAbilityDto} used as test data. */
    private List<PokemonAbilityDto> pokemonAbilities;

    /** Sample list of {@link PokemonHeldItemDto} used as test data.*/
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
     * Tests the {@code getPokemonDetails} method to ensure it correctly fetches and returns 
     * Pokemon details.
     * <p>
     * <strong>Scenario:</strong>
     * The service is mocked to return a predefined {@link PokemonDto}. The adapter method is 
     * invoked, and the returned data is validated against the expected values.
     * </p>
     */
    @Test
    public void testGetPokemonDetails() {
        Mockito.when(pokemonService.getPokemonDetails(nameOrId,
                PokemonDto.class)).thenReturn(Mono.just(pokemon));
        Mono<PokemonDto> result = adapter.getPokemonDetails(nameOrId);
        PokemonDto actualDto = result.block();
        assertNotNull(actualDto);
        assertEquals(pokemon.getId(),
                actualDto.getId());
        assertEquals(pokemon.getName(),
                actualDto.getName());
        assertEquals(pokemon.getBaseExperience(),
                actualDto.getBaseExperience());
        Mockito.verify(pokemonService,
                Mockito.times(1)).getPokemonDetails(nameOrId,
                        PokemonDto.class);
    }

    /**
     * Tests the {@code getPokemonAbilities} method to ensure it correctly fetches and returns 
     * Pokemon abilities.
     * <p>
     * <strong>Scenario:</strong>
     * The service is mocked to return a predefined list of {@link PokemonAbilityDto}. 
     * The adapter method is invoked, and the returned abilities are validated for size and content.
     * </p>
     */
    @SuppressWarnings("unchecked")
    @Test
    public void testGetPokemonAbilities_Success() {
        when(pokemonService.getPokemonAbilities(eq(nameOrId),
                any(TypeReference.class))).thenReturn(Mono.just(pokemonAbilities));
        Mono<List<PokemonAbilityDto>> result = adapter.getPokemonAbilities(nameOrId);
        List<PokemonAbilityDto> actualAbilities = result.block();
        assertNotNull(actualAbilities);
        assertEquals(3,
                actualAbilities.size());
        assertEquals(pokemonAbilities.get(0).getAbility().getName(),
                actualAbilities.get(0).getAbility().getName());
        assertFalse(actualAbilities.get(0).getIsHidden());
        assertEquals(pokemonAbilities.get(2).getAbility().getName(),
                actualAbilities.get(2).getAbility().getName());
        assertTrue(actualAbilities.get(2).getIsHidden());

        verify(pokemonService,
                times(1)).getPokemonAbilities(eq(nameOrId),
                        any(TypeReference.class));
    }

    /**
     * Tests the {@code getPokemonHeldItems} method to ensure it correctly fetches and returns 
     * Pokemon held items.
     * <p>
     * <strong>Scenario:</strong>
     * The service is mocked to return a predefined list of {@link PokemonHeldItemDto}. The adapter
     *  method is invoked,
     * and the returned held items are validated for size and content.
     * </p>
     */
    @SuppressWarnings("unchecked")
    @Test
    public void testGetPokemonHeldItems_Success() {
        when(pokemonService.getPokemonHeldItems(eq(nameOrId),
                any(TypeReference.class))).thenReturn(Mono.just(pokemonHeldItems));
        Mono<List<PokemonHeldItemDto>> result = adapter.getPokemonHeldItems(nameOrId);
        List<PokemonHeldItemDto> actualHeldItems = result.block();
        assertNotNull(actualHeldItems);
        assertEquals(pokemonHeldItems.size(),
                actualHeldItems.size());
        assertEquals(pokemonHeldItems.get(0).getVersionDetails().get(0).getRarity(),
                actualHeldItems.get(0).getVersionDetails().get(0).getRarity());
        assertEquals(pokemonHeldItems.get(0).getItem().getName(),
                actualHeldItems.get(0).getItem().getName());
        verify(pokemonService,
                times(1)).getPokemonHeldItems(eq(nameOrId),
                        any(TypeReference.class));
    }

}
