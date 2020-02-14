package com.andrelangner.marvelapi.controllers.endpoint;

import com.andrelangner.marvelapi.dtos.*;
import com.andrelangner.marvelapi.services.api.ICharacterService;
import com.andrelangner.marvelapi.services.api.IComicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/v1/public/characters", produces = "application/json; charset=utf-8")
@Validated
public class CharacterEndpoint {

    @Autowired
    ICharacterService characterService;

    @Autowired
    IComicService comicService;

    @GetMapping
    public ResponseEntity<DataWrapperDTO<CharacterDTO>> getCharacters(@Valid CharacterParamsDTO params) {
        return ResponseEntity.ok(DataWrapperDTO.<CharacterDTO>builder()
                .data(characterService.findAll(params))
                .build());
    }

    @GetMapping("/{characterId}")
    public ResponseEntity<DataWrapperDTO<CharacterDTO>> getByCharacterId(@PathVariable("characterId") Long characterId) {
        CharacterParamsDTO params = CharacterParamsDTO.builder().build();

        return ResponseEntity.ok(DataWrapperDTO.<CharacterDTO>builder()
                .data(characterService.findAll(params, characterId))
                .build());
    }

    @GetMapping("/{characterId}/comics")
    public ResponseEntity<DataWrapperDTO<ComicDTO>> getComics(@PathVariable("characterId") Long characterId,  @Valid ComicParamsDTO params) {
        return ResponseEntity.ok(DataWrapperDTO.<ComicDTO>builder()
                .data(comicService.findAll(params, characterId))
                .build());
    }
}
