package com.bankaya.pokemon.fixture;

import java.util.List;
import java.util.stream.Collectors;

import com.bankaya.pokemon.dto.NamedApiResourceDto;
import com.bankaya.pokemon.dto.PokemonAbilityDto;

/**
 * Fixture class for creating sample {@link PokemonAbilityDto} instances.
 * <p>
 * This class provides utility methods to generate mock data for Pokemon abilities,
 * facilitating the creation of consistent and reusable test data for unit and integration tests.
 * </p>
 * 
 * <p><strong>Usage:</strong></p>
 * <ul>
 *   <li>Used in test cases to create sample ability resources and DTOs.</li>
 *   <li>Ensures uniformity and reduces duplication in test data setup.</li>
 * </ul>
 * 
 * @see PokemonAbilityDto
 * @see NamedApiResourceDto
 */
public class PokemonAbilityFixture {

    /**
     * Creates a sample {@link NamedApiResourceDto} representing an API resource with the given 
     * name and URL.
     *
     * @param name The name of the API resource.
     * @param url  The URL of the API resource.
     * @return A {@link NamedApiResourceDto} instance with the specified name and URL.
     */
    public static NamedApiResourceDto<?> createSampleResource(String name, String url) {
        return NamedApiResourceDto.builder().name(name).url(url).build();
    }

    /**
     * Creates a sample {@link PokemonAbilityDto} based on the provided {@link Constant.Ability} 
     * enumeration.
     *
     * @param ability The {@link Constant.Ability} enumeration representing the ability details.
     * @return A {@link PokemonAbilityDto} instance constructed from the given ability.
     */
    public static PokemonAbilityDto createAbility(Constant.Ability ability) {
        return PokemonAbilityDto.builder().ability(createSampleResource(ability.getName(),
                ability.getUrl())).isHidden(ability.isHidden()).slot(ability.getSlot()).build();
    }

    /**
     * Creates a list of {@link PokemonAbilityDto} instances from a list of {@link Constant.Ability}
     *  enumerations.
     *
     * @param abilities A list of {@link Constant.Ability} enumerations representing various 
     * abilities.
     * @return A list of {@link PokemonAbilityDto} instances corresponding to the provided 
     * abilities.
     */
    public static List<PokemonAbilityDto> createPokemonAbilities(List<Constant.Ability> abilities) {
        return abilities.stream().map(PokemonAbilityFixture::createAbility)
                .collect(Collectors.toList());
    }
}
