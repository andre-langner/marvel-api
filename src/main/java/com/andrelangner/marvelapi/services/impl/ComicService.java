package com.andrelangner.marvelapi.services.impl;

import com.andrelangner.marvelapi.components.api.ISortComponent;
import com.andrelangner.marvelapi.components.api.IWhereComponent;
import com.andrelangner.marvelapi.converters.api.IComicEntityToComicDTOConverter;
import com.andrelangner.marvelapi.dtos.*;
import com.andrelangner.marvelapi.entities.ComicEntity;
import com.andrelangner.marvelapi.repositories.IComicRepository;
import com.andrelangner.marvelapi.services.api.IComicService;
import com.andrelangner.marvelapi.specs.ComicSpecs;
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
public class ComicService implements IComicService {

    @Autowired
    IComicRepository comicRepository;

    @Autowired
    IComicEntityToComicDTOConverter comicEntityToComicDTOConverter;

    @Autowired
    IWhereComponent whereComponent;

    @Autowired
    ISortComponent sortComponent;

    private Specification<ComicEntity> getWhereForFindAll(ComicParamsDTO params, Long characters){
        Specification<ComicEntity> where = null;
        where = whereComponent.add(where, ComicSpecs.byCharacter(characters));

        return where;
    }

    @Override
    public DataContainerDTO<ComicDTO> findAll(ComicParamsDTO params, Long characters) {
        int page = PageFunctions.getPageNumber(params.getOffset(), params.getLimit());

        sortComponent.initDefault(params.getOrderBy(), "title");

        Pageable pageable = PageRequest.of(page, params.getLimit(), sortComponent.get(params.getOrderBy()));

        Page<ComicEntity> comics = comicRepository.findAll(getWhereForFindAll(params, characters), pageable);

        List<ComicDTO> comicsDTO = comics.getContent().stream().map(
                    characterEntity -> comicEntityToComicDTOConverter.convert(characterEntity)
                ).collect(Collectors.toList());

        return DataContainerDTO.<ComicDTO>builder()
                .count((long) comicsDTO.size())
                .offset(params.getOffset())
                .limit(params.getLimit())
                .total(comics.getTotalElements())
                .results(comicsDTO)
                .build();
    }

    @Override
    public void getComics(ResourceDTO<ComicResourceDTO> dto, Long characterId) {
        ComicParamsDTO comicParamsDTO = ComicParamsDTO.builder()
                .offset(0)
                .limit(20)
                .build();

        DataContainerDTO<ComicDTO> comics = findAll(comicParamsDTO, characterId);

        dto.setAvailable(comics.getTotal());
        dto.setCollectionURI("http://gateway.marvel.com/v1/public/characters/" + characterId + "/comics");
        dto.setReturned(comics.getCount());
        for (ComicDTO comicDTO : comics.getResults()) {
            dto.getItems().add(ComicResourceDTO.builder()
                    .name(comicDTO.getTitle())
                    .resourceURI("http://gateway.marvel.com/v1/public/comics/" + comicDTO.getId())
                    .build());
        }
    }
}
