package com.bankaya.pokemon.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class PokemonHeldItemVersionDto.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PokemonHeldItemVersionDto {

    /** The version. */
    private NamedApiResourceDto<?> version;
    
    /** The rarity. */
    private Integer rarity;

}
