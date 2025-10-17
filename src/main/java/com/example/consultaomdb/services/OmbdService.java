package com.example.consultaomdb.services;

import com.example.consultaomdb.dtos.FilmeResponseDto;
import com.example.consultaomdb.dtos.OmdbFilmeResponseDto;
import com.example.consultaomdb.dtos.RatingDto;
import com.example.consultaomdb.exceptions.MovieCantBeEmptyException;
import com.example.consultaomdb.exceptions.MovieNotFoundException;
import com.example.consultaomdb.feign.OmdbFeignClient;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OmbdService {

    @Autowired
    private OmdbFeignClient omdbFeignClient;

    public FilmeResponseDto consultaFilmePeloTitulo(String title, String apiKey, String type) {
        if (title == null || title.trim().isEmpty() || !title.matches("[a-zA-Z0-9]+")) {
            throw new MovieCantBeEmptyException("O título do filme deve ser informado e conter caracteres alfanuméricos");
        }
        if (apiKey == null || apiKey.trim().isEmpty()) {
            throw new MovieCantBeEmptyException("A chave da API deve ser informada");
        }
        if (type == null || type.trim().isEmpty()) {
            throw new MovieCantBeEmptyException("O tipo do filme deve ser informado");
        }

        OmdbFilmeResponseDto omdbResponse = omdbFeignClient.consultaFilme(title, apiKey, type);

        if (omdbResponse == null || omdbResponse.name() == null || omdbResponse.name().trim().isEmpty()) {
            throw new MovieNotFoundException("Filme com título '" + title + "' não encontrado");
        }

        String ratingValue = null;
        List<RatingDto> ratings = omdbResponse.ratings();
        if (ratings != null && !ratings.isEmpty()) {
            ratingValue = ratings.get(0).classificacao();
        }

        return new FilmeResponseDto(
                omdbResponse.name(),
                omdbResponse.ano(),
                omdbResponse.duracao(),
                omdbResponse.descricao(),
                ratingValue
        );
    }
}
