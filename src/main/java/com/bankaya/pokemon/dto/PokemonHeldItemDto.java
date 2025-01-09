package com.bankaya.pokemon.dto;

import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class PokemonHeldItemDto.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PokemonHeldItemDto {

    /** The item. */
    private NamedApiResourceDto<?> item;
    
    /** The version details. */
    private List<PokemonHeldItemVersionDto> versionDetails;

}
