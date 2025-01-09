package com.bankaya.pokemon.fixture;

import java.util.List;
import java.util.stream.Collectors;
import com.bankaya.pokemon.dto.NamedApiResourceDto;
import com.bankaya.pokemon.dto.PokemonHeldItemDto;
import com.bankaya.pokemon.dto.PokemonHeldItemVersionDto;

/**
 * Fixture class for creating sample {@link PokemonHeldItemDto} instances.
 * <p>
 * This class provides utility methods to generate mock data for Pokémon held items,
 * including specific versions and rarity, facilitating the creation of consistent and reusable test data.
 * </p>
 * 
 * <p><strong>Usage:</strong></p>
 * <ul>
 *   <li>Used in test cases to create sample held item resources and DTOs.</li>
 *   <li>Ensures uniformity and reduces duplication in test data setup.</li>
 * </ul>
 * 
 * @see PokemonHeldItemDto
 * @see PokemonHeldItemVersionDto
 * @see NamedApiResourceDto
 */
public class PokemonHeldItemFixture {

    /**
     * Creates a sample {@link PokemonHeldItemDto} representing a held item with its associated 
     * versions and rarity.
     *
     * @param item      The {@link NamedApiResourceDto} representing the held item.
     * @param versions  A list of {@link Constant.HeldItemVersion} enumerations representing the 
     * item versions.
     * @param rarity    The rarity level of the held item.
     * @return A {@link PokemonHeldItemDto} instance with the specified item, versions, and rarity.
     */
    public static PokemonHeldItemDto createHeldItem(NamedApiResourceDto<?> item,
            List<Constant.HeldItemVersion> versions, int rarity) {
        return PokemonHeldItemDto.builder().item(item).versionDetails(createVersionDetails(versions,
                rarity)).build();
    }

    /**
     * Creates a sample {@link NamedApiResourceDto} representing an API resource with the given 
     * name and URL.
     *
     * @param name The name of the API resource.
     * @param url  The URL of the API resource.
     * @return A {@link NamedApiResourceDto} instance with the specified name and URL.
     */
    public static NamedApiResourceDto<?> createSampleItem(String name, String url) {
        return NamedApiResourceDto.builder().name(name).url(url).build();
    }
    
    /**
     * Creates a sample {@link PokemonHeldItemVersionDto} representing the version details of a 
     * held item.
     *
     * @param version The {@link Constant.HeldItemVersion} enumeration representing the version 
     * details.
     * @param rarity  The rarity level of the held item in this version.
     * @return A {@link PokemonHeldItemVersionDto} instance with the specified version and rarity.
     */
    public static PokemonHeldItemVersionDto createHeldItemVersion(Constant.HeldItemVersion version,
            int rarity) {
        return PokemonHeldItemVersionDto.builder().version(createSampleItem(version.getName(),
                version.getUrl())).rarity(rarity).build();
    }

    /**
     * Creates a list of {@link PokemonHeldItemVersionDto} instances from a list of 
     * {@link Constant.HeldItemVersion} enumerations.
     *
     * @param versions A list of {@link Constant.HeldItemVersion} enumerations representing various 
     * versions.
     * @param rarity   The rarity level to be applied to all versions.
     * @return A list of {@link PokemonHeldItemVersionDto} instances corresponding to the provided 
     * versions.
     */
    public static List<PokemonHeldItemVersionDto> createVersionDetails(
            List<Constant.HeldItemVersion> versions, int rarity) {
        return versions.stream().map(version -> createHeldItemVersion(version,
                rarity)).collect(Collectors.toList());
    }
}
