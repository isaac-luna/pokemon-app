package com.bankaya.pokemon.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class PokemonAbilityDto.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PokemonAbilityDto {

    /** The is hidden. */
    private Boolean isHidden;
    
    /** The slot. */
    private Integer slot;
    
    /** The ability. */
    private NamedApiResourceDto<?> ability;

}
