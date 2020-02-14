package com.andrelangner.marvelapi.services.api;

import com.andrelangner.marvelapi.dtos.*;

public interface IComicService {

    DataContainerDTO<ComicDTO> findAll(ComicParamsDTO params, Long character);
    void getComics(ResourceDTO<ComicResourceDTO> dto, Long characterId);
}
