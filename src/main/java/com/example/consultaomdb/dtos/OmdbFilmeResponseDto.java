package com.example.consultaomdb.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public record OmdbFilmeResponseDto(
        @JsonProperty("Title") String name,
        @JsonProperty("Year") String ano,
        @JsonProperty("Runtime") String duracao,
        @JsonProperty("Plot") String descricao,
        @JsonProperty("Ratings") List<RatingDto> ratings
) {}

