package com.andrelangner.marvelapi.services.impl;

import com.andrelangner.marvelapi.components.api.ISortComponent;
import com.andrelangner.marvelapi.components.api.IWhereComponent;
import com.andrelangner.marvelapi.converters.api.ICharacterEntityToCharacterDTOConverter;
import com.andrelangner.marvelapi.dtos.*;
import com.andrelangner.marvelapi.entities.CharacterEntity;
import com.andrelangner.marvelapi.repositories.ICharacterRepository;
import com.andrelangner.marvelapi.services.api.*;
import com.andrelangner.marvelapi.specs.CharacterSpecs;
import com.andrelangner.marvelapi.utils.PageFunctions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CharacterService implements ICharacterService {

    @Autowired
    ICharacterRepository characterRepository;

    @Autowired
    ICharacterEntityToCharacterDTOConverter characterEntityToCharacterDTOConverter;

    @Autowired
    IWhereComponent whereComponent;

    @Autowired
    ISortComponent sortComponent;

    @Autowired
    IComicService comicService;

    @Autowired
    IEventService eventService;

    @Autowired
    ISerieService serieService;

    @Autowired
    IStoryService storyService;

    private Specification<CharacterEntity> getWhereForFindAll(CharacterParamsDTO params, Long characterId){
        Specification<CharacterEntity> where = null;

        where = whereComponent.add(where, CharacterSpecs.byCharacter(characterId));
        where = whereComponent.add(where, CharacterSpecs.byName(params.getName()));
        where = whereComponent.add(where, CharacterSpecs.nameStartWith(params.getNameStartsWith()));
        where = whereComponent.add(where, CharacterSpecs.modifiedSince(params.getModifiedSince()));

        where = whereComponent.add(where, CharacterSpecs.byComics(params.getComics()));
        where = whereComponent.add(where, CharacterSpecs.byEvents(params.getEvents()));
        where = whereComponent.add(where, CharacterSpecs.byStories(params.getStories()));
        where = whereComponent.add(where, CharacterSpecs.bySeries(params.getSeries()));

        return where;
    }

    @Override
    public DataContainerDTO<CharacterDTO> findAll(CharacterParamsDTO params) {
        return findAll(params, null);
    }

    @Override
    public DataContainerDTO<CharacterDTO> findAll(CharacterParamsDTO params, Long character) {
        int page = PageFunctions.getPageNumber(params.getOffset(), params.getLimit());

        sortComponent.initDefault(params.getOrderBy(), "name");

        Pageable pageable = PageRequest.of(page, params.getLimit(), sortComponent.get(params.getOrderBy()));

        Page<CharacterEntity> characters = characterRepository.findAll(getWhereForFindAll(params, character), pageable);

        List<CharacterDTO> charactesDTO = characters.getContent().stream().map(
                characterEntity -> characterEntityToCharacterDTOConverter.convert(characterEntity)
        ).collect(Collectors.toList());

        for (CharacterDTO characterDTO : charactesDTO) {
            comicService.getComics(characterDTO.getComics(), characterDTO.getId());
            serieService.getSeries(characterDTO.getSeries(), characterDTO.getId());
            storyService.getStories(characterDTO.getStories(), characterDTO.getId());
            eventService.getEvents(characterDTO.getEvents(), characterDTO.getId());
        }

        return DataContainerDTO.<CharacterDTO>builder()
                .count((long) charactesDTO.size())
                .offset(params.getOffset())
                .limit(params.getLimit())
                .total(characters.getTotalElements())
                .results(charactesDTO)
                .build();
    }
}
