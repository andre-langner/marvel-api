package com.andrelangner.marvelapi.converters.impl;

import com.andrelangner.marvelapi.converters.api.IComicEntityToComicDTOConverter;
import com.andrelangner.marvelapi.dtos.ComicDTO;
import com.andrelangner.marvelapi.entities.ComicEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ComicEntityToComicDTOConverter implements IComicEntityToComicDTOConverter {

    @Autowired
    protected ModelMapper modelMapper;

    @Override
    public ComicDTO convert(ComicEntity comicEntity) {
        ComicDTO result = modelMapper.map(comicEntity, ComicDTO.class);
        result.setResourceURI("http://gateway.marvel.com/v1/public/comics/" + result.getId());
        return result;
    }
}
