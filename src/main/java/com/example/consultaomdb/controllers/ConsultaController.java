package com.example.consultaomdb.controllers;

import com.example.consultaomdb.dtos.FilmeResponseDto;
import com.example.consultaomdb.services.OmbdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ConsultaController {

    @Autowired
    private OmbdService omdbService;

    @GetMapping("/consulta/{title}/{apiKey}")
    public ResponseEntity<FilmeResponseDto> consultaPorNome(
            @PathVariable String title,
            @PathVariable String apiKey,
            @RequestParam(value = "type", required = false) String type) {
        return ResponseEntity.ok(omdbService.consultaFilmePeloTitulo(title, apiKey, type));
    }
}
