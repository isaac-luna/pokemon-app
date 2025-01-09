package com.bankaya.pokemon.dto;

import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class PokemonDto.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PokemonDto implements PokeApiResource {

    /** The abilities. */
    private List<PokemonAbilityDto> abilities;
    
    /** The base experience. */
    private Integer baseExperience;
    
    /** The held items. */
    private List<PokemonHeldItemDto> heldItems;
    
    /** The id. */
    private Integer id;
    
    /** The name. */
    private String name;
    
    /** The location area encounters. */
    private String locationAreaEncounters;

}
