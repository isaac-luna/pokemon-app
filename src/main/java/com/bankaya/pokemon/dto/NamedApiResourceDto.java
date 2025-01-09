package com.bankaya.pokemon.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class NamedApiResourceDto.
 *
 * @param <T> the generic type
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class NamedApiResourceDto<T extends PokeApiResource> {

    /** The name. */
    private String name;
    
    /** The url. */
    private String url;

}
