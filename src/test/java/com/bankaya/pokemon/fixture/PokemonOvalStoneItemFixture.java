package com.bankaya.pokemon.fixture;

import static com.bankaya.pokemon.fixture.Constant.HeldItemVersion.DIAMOND;
import static com.bankaya.pokemon.fixture.Constant.HeldItemVersion.HEARTGOLD;
import static com.bankaya.pokemon.fixture.Constant.HeldItemVersion.PEARL;
import static com.bankaya.pokemon.fixture.Constant.HeldItemVersion.PLATINUM;
import static com.bankaya.pokemon.fixture.Constant.HeldItemVersion.SOULSILVER;

import java.util.Arrays;
import java.util.List;

import com.bankaya.pokemon.dto.NamedApiResourceDto;
import com.bankaya.pokemon.dto.PokemonHeldItemDto;

/**
 * Fixture class for creating sample {@link PokemonHeldItemDto} instances specific to the 
 * "Oval Stone" item.
 * <p>
 * This class provides utility methods to generate mock data for the "Oval Stone" held item,
 * including associated versions and rarity, facilitating the creation of consistent and reusable 
 * test data.
 * </p>
 * 
 * <p><strong>Usage:</strong></p>
 * <ul>
 *   <li>Used in test cases to create sample "Oval Stone" held items.</li>
 *   <li>Ensures uniformity and reduces duplication in test data setup for specific held items.</li>
 * </ul>
 * 
 * @see PokemonHeldItemDto
 * @see PokemonHeldItemFixture
 * @see NamedApiResourceDto
 */
public class PokemonOvalStoneItemFixture {

    /**
     * Creates a sample {@link NamedApiResourceDto} representing the "Oval Stone" held item.
     *
     * @return A {@link NamedApiResourceDto} instance for the "Oval Stone" item.
     */
    public static NamedApiResourceDto<?> createSampleOvalStoneItem() {
        return PokemonHeldItemFixture.createSampleItem("oval-stone",
                "https://pokeapi.co/api/v2/item/110/");
    }

    /**
     * Creates a sample {@link PokemonHeldItemDto} representing the "Oval Stone" held item with 
     * predefined versions and rarity.
     *
     * @return A {@link PokemonHeldItemDto} instance for the "Oval Stone" item.
     */
    public static PokemonHeldItemDto createSampleHeldItem() {
        List<Constant.HeldItemVersion> selectedVersions = Arrays.asList(DIAMOND,
                PEARL,
                PLATINUM,
                HEARTGOLD,
                SOULSILVER);
        return PokemonHeldItemFixture.createHeldItem(createSampleOvalStoneItem(),
                selectedVersions,
                50);
    }

}
