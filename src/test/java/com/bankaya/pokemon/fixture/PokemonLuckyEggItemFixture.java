package com.bankaya.pokemon.fixture;

import static com.bankaya.pokemon.fixture.Constant.HeldItemVersion.ALPHA_SAPPHIRE;
import static com.bankaya.pokemon.fixture.Constant.HeldItemVersion.BLACK;
import static com.bankaya.pokemon.fixture.Constant.HeldItemVersion.BLACK_2;
import static com.bankaya.pokemon.fixture.Constant.HeldItemVersion.DIAMOND;
import static com.bankaya.pokemon.fixture.Constant.HeldItemVersion.EMERALD;
import static com.bankaya.pokemon.fixture.Constant.HeldItemVersion.FIRERED;
import static com.bankaya.pokemon.fixture.Constant.HeldItemVersion.HEARTGOLD;
import static com.bankaya.pokemon.fixture.Constant.HeldItemVersion.LEAFGREEN;
import static com.bankaya.pokemon.fixture.Constant.HeldItemVersion.OMEGA_RUBY;
import static com.bankaya.pokemon.fixture.Constant.HeldItemVersion.PEARL;
import static com.bankaya.pokemon.fixture.Constant.HeldItemVersion.PLATINUM;
import static com.bankaya.pokemon.fixture.Constant.HeldItemVersion.RUBY;
import static com.bankaya.pokemon.fixture.Constant.HeldItemVersion.SAPPHIRE;
import static com.bankaya.pokemon.fixture.Constant.HeldItemVersion.SOULSILVER;
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
 * "Lucky Egg" item.
 * <p>
 * This class provides utility methods to generate mock data for the "Lucky Egg" held item,
 * including associated versions and rarity, facilitating the creation of consistent and reusable 
 * test data.
 * </p>
 * 
 * <p><strong>Usage:</strong></p>
 * <ul>
 *   <li>Used in test cases to create sample "Lucky Egg" held items.</li>
 *   <li>Ensures uniformity and reduces duplication in test data setup for specific held items.</li>
 * </ul>
 * 
 * @see PokemonHeldItemDto
 * @see PokemonHeldItemFixture
 * @see NamedApiResourceDto
 */
public class PokemonLuckyEggItemFixture {

    /**
     * Creates a sample {@link NamedApiResourceDto} representing the "Lucky Egg" held item.
     *
     * @return A {@link NamedApiResourceDto} instance for the "Lucky Egg" item.
     */
    public static NamedApiResourceDto<?> createSampleLuckyEggItem() {
        return PokemonHeldItemFixture.createSampleItem("lucky-egg",
                "https://pokeapi.co/api/v2/item/208/");
    }

    /**
     * Creates a sample {@link PokemonHeldItemDto} representing the "Lucky Egg" held item with 
     * predefined versions and rarity.
     *
     * @return A {@link PokemonHeldItemDto} instance for the "Lucky Egg" item.
     */
    public static PokemonHeldItemDto createSampleHeldItem() {
        List<Constant.HeldItemVersion> selectedVersions = Arrays.asList(RUBY,
                SAPPHIRE,
                EMERALD,
                FIRERED,
                LEAFGREEN,
                DIAMOND,
                PEARL,
                PLATINUM,
                HEARTGOLD,
                SOULSILVER,
                BLACK,
                WHITE,
                BLACK_2,
                WHITE_2,
                X,
                Y,
                OMEGA_RUBY,
                ALPHA_SAPPHIRE);
        return PokemonHeldItemFixture.createHeldItem(createSampleLuckyEggItem(),
                selectedVersions,
                5);
    }

}
