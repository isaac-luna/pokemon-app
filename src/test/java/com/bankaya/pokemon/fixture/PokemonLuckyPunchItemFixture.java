package com.bankaya.pokemon.fixture;

import static com.bankaya.pokemon.fixture.Constant.HeldItemVersion.ALPHA_SAPPHIRE;
import static com.bankaya.pokemon.fixture.Constant.HeldItemVersion.BLACK;
import static com.bankaya.pokemon.fixture.Constant.HeldItemVersion.BLACK_2;
import static com.bankaya.pokemon.fixture.Constant.HeldItemVersion.MOON;
import static com.bankaya.pokemon.fixture.Constant.HeldItemVersion.OMEGA_RUBY;
import static com.bankaya.pokemon.fixture.Constant.HeldItemVersion.SUN;
import static com.bankaya.pokemon.fixture.Constant.HeldItemVersion.ULTRA_MOON;
import static com.bankaya.pokemon.fixture.Constant.HeldItemVersion.ULTRA_SUN;
import static com.bankaya.pokemon.fixture.Constant.HeldItemVersion.WHITE;
import static com.bankaya.pokemon.fixture.Constant.HeldItemVersion.WHITE_2;
import static com.bankaya.pokemon.fixture.Constant.HeldItemVersion.X;
import static com.bankaya.pokemon.fixture.Constant.HeldItemVersion.Y;
import java.util.Arrays;
import java.util.List;
import com.bankaya.pokemon.dto.NamedApiResourceDto;
import com.bankaya.pokemon.dto.PokemonHeldItemDto;

/**
 * Fixture class for creating sample {@link PokemonHeldItemDto} instances specific to the 
 * "Lucky Punch" item.
 * <p>
 * This class provides utility methods to generate mock data for the "Lucky Punch" held item,
 * including associated versions and rarity, facilitating the creation of consistent and reusable 
 * test data.
 * </p>
 * 
 * <p><strong>Usage:</strong></p>
 * <ul>
 *   <li>Used in test cases to create sample "Lucky Punch" held items.</li>
 *   <li>Ensures uniformity and reduces duplication in test data setup for specific held items.</li>
 * </ul>
 * 
 * @see PokemonHeldItemDto
 * @see PokemonHeldItemFixture
 * @see NamedApiResourceDto
 */
public class PokemonLuckyPunchItemFixture {

    /**
     * Creates a sample {@link NamedApiResourceDto} representing the "Lucky Punch" held item.
     *
     * @return A {@link NamedApiResourceDto} instance for the "Lucky Punch" item.
     */
    public static NamedApiResourceDto<?> createSampleLuckyPunchItem() {
        return PokemonHeldItemFixture.createSampleItem("lucky-punch",
                "https://pokeapi.co/api/v2/item/233/");
    }

    /**
     * Creates a sample {@link PokemonHeldItemDto} representing the "Lucky Punch" held item with 
     * predefined versions and rarity.
     *
     * @return A {@link PokemonHeldItemDto} instance for the "Lucky Punch" item.
     */
    public static PokemonHeldItemDto createSampleHeldItem() {
        List<Constant.HeldItemVersion> selectedVersions = Arrays.asList(BLACK,
                WHITE,
                BLACK_2,
                WHITE_2,
                X,
                Y,
                OMEGA_RUBY,
                ALPHA_SAPPHIRE,
                SUN,
                MOON,
                ULTRA_SUN,
                ULTRA_MOON);
        return PokemonHeldItemFixture.createHeldItem(createSampleLuckyPunchItem(),
                selectedVersions,
                5);
    }

}
