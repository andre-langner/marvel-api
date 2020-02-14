package com.andrelangner.marvelapi.converters.api;

import com.andrelangner.marvelapi.dtos.ComicDTO;
import com.andrelangner.marvelapi.entities.ComicEntity;

public interface IComicEntityToComicDTOConverter {
    ComicDTO convert(ComicEntity characterEntity);
}
