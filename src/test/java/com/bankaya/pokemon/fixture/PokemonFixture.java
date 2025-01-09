package com.bankaya.pokemon.fixture;

import static com.bankaya.pokemon.fixture.Constant.Ability.HEALER;
import static com.bankaya.pokemon.fixture.Constant.Ability.NATURAL_CURE;
import static com.bankaya.pokemon.fixture.Constant.Ability.SERENE_GRACE;

import java.util.Arrays;
import java.util.List;

import com.bankaya.pokemon.dto.PokemonAbilityDto;
import com.bankaya.pokemon.dto.PokemonDto;
import com.bankaya.pokemon.dto.PokemonHeldItemDto;

/**
 * Fixture class for creating sample {@link PokemonDto} instances.
 * <p>
 * This class provides utility methods to generate mock Pokémon data, including abilities and held 
 * items,
 * which are essential for setting up consistent and reusable test scenarios in unit and integration
 * tests.
 * </p>
 * 
 * <p><strong>Usage:</strong></p>
 * <ul>
 *   <li>Used in test cases to create sample Pokémon DTOs with predefined attributes.</li>
 *   <li>Facilitates the testing of services and controllers that handle Pokémon data.</li>
 * </ul>
 * 
 * @see PokemonDto
 * @see PokemonAbilityFixture
 * @see PokemonHeldItemDto
 */
public class PokemonFixture {

    /**
     * Creates a sample {@link PokemonDto} instance with predefined attributes.
     *
     * @return A {@link PokemonDto} instance representing a sample Pokémon.
     */
    public static PokemonDto createSamplePokemonDto() {
        return PokemonDto.builder().id(113).name("chansey").abilities(createSampleAbilities())
                .baseExperience(395).heldItems(null)
                .locationAreaEncounters("https://pokeapi.co/api/v2/pokemon/113/encounters").build();
    }

    /**
     * Creates a list of sample {@link PokemonAbilityDto} instances.
     *
     * @return A list of {@link PokemonAbilityDto} instances representing sample abilities.
     */
    public static List<PokemonAbilityDto> createSampleAbilities() {
        List<Constant.Ability> selectedAbilities = Arrays.asList(NATURAL_CURE,
                SERENE_GRACE,
                HEALER);
        return PokemonAbilityFixture.createPokemonAbilities(selectedAbilities);
    }

    /**
     * Creates a list of sample {@link PokemonHeldItemDto} instances.
     *
     * @return A list of {@link PokemonHeldItemDto} instances representing sample held items.
     */
    public static List<PokemonHeldItemDto> createSampleHeldItems() {
        return Arrays.asList(PokemonOvalStoneItemFixture.createSampleHeldItem(),
                PokemonLuckyEggItemFixture.createSampleHeldItem(),
                PokemonLuckyPunchItemFixture.createSampleHeldItem());
    }

}
