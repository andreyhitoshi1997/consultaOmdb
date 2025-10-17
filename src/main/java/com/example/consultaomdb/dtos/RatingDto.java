package com.example.consultaomdb.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public record RatingDto(
    @JsonProperty("Value") String classificacao
) {}
