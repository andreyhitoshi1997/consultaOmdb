package com.example.consultaomdb.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public record FilmeResponseDto(
        @JsonProperty("Title") String name,
        @JsonProperty("Year") String ano,
        @JsonProperty("Runtime") String duracao,
        @JsonProperty("Plot") String descricao,
        @JsonProperty("Ratings") String ratings
        ) {
}
