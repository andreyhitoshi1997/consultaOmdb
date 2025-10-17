package com.example.consultaomdb.feign;

import com.example.consultaomdb.dtos.OmdbFilmeResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "omdb", url = "http://www.omdbapi.com")
public interface OmdbFeignClient {

    @GetMapping
    OmdbFilmeResponseDto consultaFilme(
            @RequestParam("t") String title,
            @RequestParam("apikey") String apiKey,
            @RequestParam("type") String type);
}
