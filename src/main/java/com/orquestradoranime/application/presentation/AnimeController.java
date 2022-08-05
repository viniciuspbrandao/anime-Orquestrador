package com.orquestradoranime.application.presentation;

import com.orquestradoranime.application.infraestructure.AnimeRepositoryImpl;
import com.orquestradoranime.domain.camel.route.AnimeRouter;
import com.orquestradoranime.domain.domain.Anime;
import com.orquestradoranime.domain.port.AnimeRepository;
//import com.orquestradoranime.rabbitmq.service.RabbitmqService;
import com.orquestradoranime.application.mapper.AnimeMapper;
import com.orquestradoranime.application.presentation.representation.AnimeRequestRepresentation;
import com.orquestradoranime.application.presentation.representation.AnimeResponseRepresentation;
import com.orquestradoranime.domain.service.AnimeService;
//import com.orquestradoranime.rabbitmq.constantes.RabbitmqConstantes;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

import static java.util.Objects.nonNull;

@AllArgsConstructor
@RestController
@RequestMapping("/animes")
public class AnimeController {
    @Autowired
    private AnimeService animeService;

    @GetMapping(path = "/listarAnimes")
    public ResponseEntity<List<AnimeResponseRepresentation>> listarAnimes() {
        var animeList = animeService.listarAnimes().stream().toList();
        var representationList = AnimeMapper.toAnimeResponseRepresentationList(animeList);
        return ResponseEntity.status(HttpStatus.OK).body(representationList);
    }


    @GetMapping(path = "id/{id}")
    public ResponseEntity<AnimeResponseRepresentation> searchAnimeById(@PathVariable(value = "id") Long id) {
        var animeById = animeService.findAnimeById(id);
        return ResponseEntity.status(HttpStatus.OK).body(AnimeMapper.paraRepresentacao(animeById));
    }

    @PostMapping(path = "/salvar")
    public ResponseEntity<AnimeResponseRepresentation> inserirNovoAnime(@RequestBody AnimeRequestRepresentation body) {
        var anime = animeService.inserirNovoAnime(AnimeMapper.toDomain(body));
        if (nonNull(anime)) {
            return ResponseEntity.status(HttpStatus.CREATED).body(AnimeMapper.paraRepresentacao(anime)); //paraRepresentacao
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping(path = "/id/{id}")
    public ResponseEntity<AnimeResponseRepresentation> atualizarAnime(
            @PathVariable(value = "id") Long id,
            @RequestBody AnimeRequestRepresentation body) {

        var animeUpdated = animeService.atualizarAnime(id, AnimeMapper.toDomain(body));
        return ResponseEntity.status(HttpStatus.CREATED).body(AnimeMapper.paraRepresentacao(animeUpdated));

    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<?> deletarAnime(@PathVariable(value = "id") Long id) {
        animeService.deletarAnime(id);
        return ResponseEntity.ok().build();
    }
}

